package com.elearning.repository.users;

import com.elearning.entities.users.ProfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfRepository extends JpaRepository<ProfEntity, Long> {

    ProfEntity findByEmail(String email);
    ProfEntity findByFirstName(String firstName);


}
