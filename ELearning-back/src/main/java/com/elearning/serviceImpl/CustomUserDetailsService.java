package com.elearning.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.elearning.dto.UserDetailDTO;
import com.elearning.entities.MatiereEntity;
import com.elearning.entities.RoleEntity;
import com.elearning.entities.UserEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.MatiereRepository;
import com.elearning.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
    @Autowired
    private MatiereRepository matiereRepository;
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private ModelMapperConverter modelMapperConverter;
	

	public UserEntity findUserByLogin(String email) {
		return userRepository.findByEmail(email);
	}

	public UserEntity findUserByFirstName(String firstName) {
		return userRepository.findByFirstName(firstName);
	}

	public void saveUser(UserEntity user) {
		user.setEnabled(true);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		UserEntity user = userRepository.findByEmail(login);
		if (user != null) {
			List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
			return buildUserForAuthentication(user, authorities);
		} else {
			throw new UsernameNotFoundException("username not found");
		}
	}

	private List<GrantedAuthority> getUserAuthority(RoleEntity userRoles) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		roles.add(new SimpleGrantedAuthority(userRoles + ""));

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>(roles);
		return grantedAuthorities;
	}

	private UserDetails buildUserForAuthentication(UserEntity user, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}
	
	@Transactional
	public void update(UserDetailDTO userr) {
		// TODO Auto-generated method stub
		Optional<UserEntity> userUpdated = userRepository.findById(userr.getId());
		UserEntity u = userUpdated.get();
		
		u.setFirstName(userr.getFirstName());
		u.setEmail(userr.getEmail());
		u.setUsername(userr.getUsername());
		u.setLastName(userr.getLastName());
		u.setApropos(userr.getApropos());
		u.setStatus(userr.getStatus());
		u.setNcin(userr.getNcin());
		u.setTelephone(userr.getTelephone());
		if (userr.getImgfile() != null) {
			u.setImgfile(userr.getImgfile());	
		}
		
		
		
		for(MatiereEntity m : userr.getMatieres()) {
			MatiereEntity matiere = matiereRepository.findById(m.getId()).get();
			if (!matiere.getUsers().contains(u))
			{
				matiere.getUsers().add(u);
				
			}
			matiereRepository.save(matiere);
		}
		
		userRepository.save(u);
		
	}	
		public void updateEtudiant(UserEntity userr) {
			// TODO Auto-generated method stub
			Optional<UserEntity> userUpdated = userRepository.findById(userr.getId());
			UserEntity u = userUpdated.get();
			
			u.setFirstName(userr.getFirstName());
			u.setEmail(userr.getEmail());
			u.setUsername(userr.getUsername());
			u.setLastName(userr.getLastName());
			u.setApropos(userr.getApropos());
			u.setStatus(userr.getStatus());
			u.setClassesEtudiant(userr.getClassesEtudiant());
			u.setNcin(userr.getNcin());
			u.setTelephone(userr.getTelephone());
			if (userr.getImgfile() != null) {
				u.setImgfile(userr.getImgfile());	
			}
			
			
			
			
			
			userRepository.save(u);
			
			
		


	}
	public void activer(UserEntity userr) {
		Optional<UserEntity> userUpdated = userRepository.findById(userr.getId());
		UserEntity u = userUpdated.get();
		u.setStatus(userr.getStatus());
		userRepository.save(u);
	}
	

	public void delete(long id) {
		// TODO Auto-generated method stub
		Optional<UserEntity> user = userRepository.findById(id);
		user.ifPresent(userRepository::delete);

	}

	public List<UserEntity> getAll() {
		// TODO Auto-generated method stub
		System.out.println("Get all Users 11111...");
		return userRepository.findAll(Sort.by("username").ascending());
	}

	public Optional<UserEntity> findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}
	public UserEntity UserEntityById(Long id) {
		// TODO Auto-generated method stub
		UserEntity user = userRepository.findById(id).get();
		System.out.println(user+"jjjjjjjj");
		return user;
		
		
	}
	public List<UserEntity> findByStatusAndRoles(String status,RoleEntity roles){
		return userRepository.findByStatusAndRoles(status,roles);
	}
	public List<UserEntity> findByRoles(RoleEntity roles){
		System.out.println("Get all Users roles 11111...");
		return userRepository.findByRoles(roles);
	}
	
}
