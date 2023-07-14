package com.elearning.service;

import java.util.List;

import com.elearning.dto.ClasseDTO;

public interface ClasseService {
	 public List<ClasseDTO> findAllClasses();
		
		public void addClasse (ClasseDTO classe);

}
