package com.elearning.service;

import com.elearning.dto.UserDTO;
import com.elearning.entities.users.UserEntity;

import java.util.List;
import java.util.Optional;


public interface UserService {
    public List<UserDTO> findAllUsers();
	
	public void addUser (UserDTO user);
	
	public List<UserDTO> getAll();
	
	public Optional<UserEntity> findById(long id);

	public void update(UserEntity User);
	
	public void delete(long id);

	
	
}


