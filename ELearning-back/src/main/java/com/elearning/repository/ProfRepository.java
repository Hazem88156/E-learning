package com.elearning.repository;

import com.elearning.entities.ProfEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfRepository extends JpaRepository<ProfEntity, Long> {
}
