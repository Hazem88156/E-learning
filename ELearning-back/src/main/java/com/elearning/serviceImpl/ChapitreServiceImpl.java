package com.elearning.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dto.ChapitreDTO;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.ChapitreRepository;
import com.elearning.service.ChapitreService;

@Service
@Transactional
public class ChapitreServiceImpl implements ChapitreService{
	
	@Autowired
	private ChapitreRepository chapitreRepository;
	@Autowired
	private ModelMapperConverter modelMapperConverter;
	public List<ChapitreDTO> findAllChapitres() {
		// TODO Auto-generated method stub
		return null;
	}
	public void addChapitre(ChapitreDTO chapitre) {
		// TODO Auto-generated method stub
		
	}

	
	

}
