package com.elearning.service;

import java.util.List;

import com.elearning.dto.MatiereDTO;
import com.elearning.entities.MatiereEntity;



public interface MatiereService {
    public List<MatiereDTO> findAllMatieres();
	
	public void addMatiere (MatiereDTO matiere);

}
