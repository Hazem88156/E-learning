package com.elearning.service;

import java.util.List;
import java.util.Optional;
import com.elearning.dto.UserDTO;
import com.elearning.entities.UserEntity;


public interface UserService {
    public List<UserDTO> findAllUsers();
	
	public void addUser (UserDTO user);
	
	public List<UserDTO> getAll();
	
	public List<UserEntity> getAllManagers();
	
	public Optional<UserEntity> findById(long id);
	
	public void update( UserEntity User);
	
	public void delete(long id);

	
	
}


