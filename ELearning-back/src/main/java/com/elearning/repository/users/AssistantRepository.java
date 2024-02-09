package com.elearning.repository.users;

import com.elearning.entities.users.AssistantEntity;
import com.elearning.entities.users.ProfEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssistantRepository extends JpaRepository<AssistantEntity, Long> {
    AssistantEntity findByEmail(String email);
    AssistantEntity findByFirstName(String firstName);
}
