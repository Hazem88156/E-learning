package com.elearning.repository;

import com.elearning.entities.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.entities.ReunionEntity;

import java.util.List;

public interface ReunionRepository extends JpaRepository<ReunionEntity, Long>{

    List<ReunionEntity> findByCourUserId(Long userId);

}
