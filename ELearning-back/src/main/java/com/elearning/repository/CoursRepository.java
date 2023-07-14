package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.entities.CoursEntity;

public interface CoursRepository extends JpaRepository<CoursEntity, Long>{

}
