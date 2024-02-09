package com.elearning.repository;

import com.elearning.entities.CompteREntity;
import com.elearning.entities.CoursEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRRepository extends JpaRepository<CompteREntity, Long> {
}
