package com.elearning.serviceImpl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.elearning.dto.UserDTO;
import com.elearning.entities.UserEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.UserRepository;
import com.elearning.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ModelMapperConverter modelMapperConverter;
	
	public List<UserDTO> findAllUsers() {
		// TODO Auto-generated method stub
		return modelMapperConverter.convertAllToDTO(userRepository.findAll(), UserDTO.class);
	}
	public void addUser(UserDTO user) {
		// TODO Auto-generated method stub
		userRepository.save(modelMapperConverter.converToEntity(user, UserEntity.class));
	}
	public List<UserEntity> getAllManagers() {
		// TODO Auto-generated method stub
		return userRepository.findAllManager();
	}
	@Override
	public List<UserDTO> getAll() {
		// TODO Auto-generated method stub
		 return modelMapperConverter.convertAllToDTO(userRepository.findAll(Sort.by("username").ascending()),UserDTO.class);	
	}
	
	
	@Override
	public void update(UserEntity User) {
		
		userRepository.save(User);
		
	}
	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		   Optional<UserEntity> user = userRepository.findById(id);
	        user.ifPresent(userRepository::delete);
		
	}
	@Override
	public Optional<UserEntity> findById(long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}
	

}
