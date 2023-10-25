package com.elearning.service;

import java.util.List;
import java.util.Optional;

import com.elearning.dto.MatiereDTO;
import com.elearning.entities.MatiereEntity;


public interface MatiereService {
    public List<MatiereDTO> findAllMatieres();
	
	public MatiereDTO saveMatiere (MatiereDTO matiere);
	public Optional<MatiereDTO> updateMatiere (Long id, MatiereDTO matiere);
	public void deleteMatiere (Long id);

	public Optional<MatiereEntity> findById(long id);

}
