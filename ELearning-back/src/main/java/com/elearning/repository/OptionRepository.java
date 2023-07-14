package com.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.entities.OptionEntity;

public interface OptionRepository extends JpaRepository<OptionEntity, Long>{

}
