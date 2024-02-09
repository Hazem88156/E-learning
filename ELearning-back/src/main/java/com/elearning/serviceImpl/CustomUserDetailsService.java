package com.elearning.serviceImpl;

import com.elearning.dto.UserDTO;
import com.elearning.dto.UserDetailDTO;
import com.elearning.dto.etudiant.EtudiantDTO;
import com.elearning.entities.Role;
import com.elearning.entities.users.EtudiantEntity;
import com.elearning.entities.users.UserEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.MatiereRepository;
import com.elearning.repository.users.EtudiantRepository;
import com.elearning.repository.users.UserRepository;
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

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
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

    private List<GrantedAuthority> getUserAuthority(Role userRoles) {
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

    public Optional<UserDTO> UserEntityById(Long id) {
        if (! userRepository.existsById(id)){
            return Optional.empty();
        }
        UserEntity user = userRepository.getById(id);
        System.out.println(user + "jjjjjjjj");
        return Optional.of(ModelMapperConverter.converToDTO(user, UserDTO.class));


    }
    public Optional<EtudiantDTO> EtudiantEntityById(Long id) {
        if (! userRepository.existsById(id)){
            return Optional.empty();
        }
        EtudiantEntity user = etudiantRepository.getById(id);
        System.out.println(user + "jjjjjjjj");
        return Optional.of(ModelMapperConverter.converToDTO(user, EtudiantDTO.class));


    }

    public List<UserDTO> findByStatusAndRoles(String status, Role roles) {
        return userRepository.findByStatusAndRoles(status, roles).stream()
                .map(userEntity -> ModelMapperConverter.converToDTO(userEntity, UserDTO.class))
                .collect(Collectors.toList());
    }

    public List<UserDTO> findByRoles(Role roles) {
        System.out.println("Get all Users roles 11111...");
        return userRepository.findByRoles(roles).stream()
                .map(userEntity -> ModelMapperConverter.converToDTO(userEntity, UserDTO.class))
                .collect(Collectors.toList());
    }
    public List<EtudiantDTO> findByRolesEtudiant(Role roles) {
        System.out.println("Get all Users roles 11111...");
        return userRepository.findByRoles(roles).stream()
                .map(etudiantEntity -> ModelMapperConverter.converToDTO(etudiantEntity, EtudiantDTO.class))
                .collect(Collectors.toList());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
