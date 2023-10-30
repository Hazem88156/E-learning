package com.elearning.repository;

import com.elearning.entities.CoursEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursRepository extends JpaRepository<CoursEntity, Long>{

    boolean existsByNomCours(String nomCours);
}
