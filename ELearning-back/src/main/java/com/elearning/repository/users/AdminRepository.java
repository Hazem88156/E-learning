package com.elearning.repository.users;

import com.elearning.entities.Role;
import com.elearning.entities.users.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Long> {
    AdminEntity findByEmail(String email);
    AdminEntity findByFirstName(String firstName);

    boolean existsByRoles(Role role);
}
