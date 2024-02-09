package com.elearning.repository.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.entities.Role;
import com.elearning.entities.users.UserEntity;




public interface UserRepository extends JpaRepository<UserEntity, Long>{

	UserEntity findByEmail(String email);
	UserEntity findByFirstName(String firstName);
	List<UserEntity> findByStatusAndRoles(String status, Role role);
	List<UserEntity> findByRoles(Role role);

}
