package com.elearning.repository;

import com.elearning.entities.DocumentEntity;
import com.elearning.entities.TpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TpRepository extends JpaRepository<TpEntity, Long> {

    List<TpEntity> findByDocumentCourUserId(Long userId);


}
