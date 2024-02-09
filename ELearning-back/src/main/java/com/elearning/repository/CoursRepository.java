package com.elearning.repository;

import com.elearning.entities.CoursEntity;
import com.elearning.entities.users.EtudiantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursRepository extends JpaRepository<CoursEntity, Long>{

    boolean existsByNomCours(String nomCours);

    List<CoursEntity> findByClasseId(Long classeId);
}
