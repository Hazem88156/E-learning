package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.dto.MatiereDTO;
import com.elearning.entities.MatiereEntity;


public interface MatiereRepository extends JpaRepository<MatiereEntity, Long>{

}
