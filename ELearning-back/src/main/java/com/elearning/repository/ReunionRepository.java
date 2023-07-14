package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.entities.ReunionEntity;

public interface ReunionRepository extends JpaRepository<ReunionEntity, Long>{

}
