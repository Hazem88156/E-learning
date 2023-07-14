package com.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elearning.entities.ClasseEntity;
import com.elearning.entities.UserEntity;

public interface ClasseRepository extends JpaRepository<ClasseEntity, Long>{

}
