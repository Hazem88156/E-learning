package com.elearning.serviceImpl;

import com.elearning.dto.UserDTO;
import com.elearning.entities.users.UserEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.users.UserRepository;
import com.elearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> findAllUsers() {
		return ModelMapperConverter.convertAllToDTO(userRepository.findAll(), UserDTO.class);
	}

	public void addUser(UserDTO user) {
		userRepository.save(ModelMapperConverter.converToEntity(user, UserEntity.class));
	}
	@Override
	public List<UserDTO> getAll() {
		 return ModelMapperConverter.convertAllToDTO(userRepository.findAll(Sort.by("username").ascending()),UserDTO.class);
	}
	
	
	@Override
	public void update(UserEntity User) {
		userRepository.save(User);
	}
	@Override
	public void delete(long id) {
		   Optional<UserEntity> user = userRepository.findById(id);
	        user.ifPresent(userRepository::delete);
		
	}
	@Override
	public Optional<UserEntity> findById(long id) {
		return userRepository.findById(id);
	}

}
