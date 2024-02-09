package com.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.elearning.entities.VedioEntity;


public interface VedioRepository extends JpaRepository<VedioEntity, Long>{
	List<VedioEntity> findByCourUserId(Long userId);
}
