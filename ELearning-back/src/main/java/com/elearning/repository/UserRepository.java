package com.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elearning.entities.RoleEntity;
import com.elearning.entities.UserEntity;




public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	UserEntity findByEmail(String email);
	UserEntity findByFirstName(String firstName);
	List<UserEntity> findByStatusAndRoles(String status,RoleEntity roles);
	List<UserEntity> findByRoles(RoleEntity roles);
	
	@Query("SELECT a FROM UserEntity a WHERE isManager = true")
	List<UserEntity> findAllManager();
	

}
