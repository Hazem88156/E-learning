package com.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.entities.DocumentEntity;



public interface DocumentRepository extends JpaRepository<DocumentEntity, Long>{
	 List<DocumentEntity> findByCourUserId(Long userId);
}
