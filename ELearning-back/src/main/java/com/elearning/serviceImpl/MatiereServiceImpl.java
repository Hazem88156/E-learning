package com.elearning.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dto.MatiereDTO;
import com.elearning.entities.MatiereEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.MatiereRepository;
import com.elearning.service.MatiereService;

@Service
@Transactional
public class MatiereServiceImpl implements MatiereService{
	@Autowired
	private MatiereRepository matiereRepository;
	@Autowired
	private ModelMapperConverter modelMapperConverter;
	@Override
	public List<MatiereDTO> findAllMatieres() {
		// TODO Auto-generated method stub
		return modelMapperConverter.convertAllToDTO(matiereRepository.findAll(), MatiereDTO.class);
	}
	@Override
	public void addMatiere(MatiereDTO matiere) {
		// TODO Auto-generated method stub
		matiereRepository.save(modelMapperConverter.converToEntity(matiere, MatiereEntity.class));
		
	}

	

}
