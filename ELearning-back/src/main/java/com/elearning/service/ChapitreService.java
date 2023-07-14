package com.elearning.service;

import java.util.List;

import com.elearning.dto.ChapitreDTO;


public interface ChapitreService {
	
public List<ChapitreDTO> findAllChapitres();
	
	public void addChapitre (ChapitreDTO chapitre);

}
