package com.elearning.service;

import java.util.List;
import java.util.Optional;

import com.elearning.dto.ClasseDTO;
import com.elearning.entities.ClasseEntity;

public interface ClasseService {
	 public List<ClasseDTO> findAllClasses();
	public void saveClasse(ClasseDTO classes);

	public Optional<ClasseDTO> updateClasse(ClasseDTO classe);
	public void deleteClasse(Long id);
	public Optional<ClasseEntity> findById(Long id);
}
