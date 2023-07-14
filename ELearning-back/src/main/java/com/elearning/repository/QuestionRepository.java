package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.entities.QuestionEntity;



public interface QuestionRepository extends JpaRepository<QuestionEntity, Long>{
	
	

}
