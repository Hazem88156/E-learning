package com.elearning.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.elearning.dto.ClasseDTO;
import com.elearning.entities.ClasseEntity;
import com.elearning.entities.CoursEntity;
import com.elearning.repository.CoursRepository;
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
	private CoursRepository coursRepository;
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
	public void saveMatiere(MatiereDTO matieres) {
		List<CoursEntity> cours = new ArrayList<>() ;
		//System.out.println(classes.getUsers());
		for (CoursEntity c : matieres.getCours() ) {
			CoursEntity cour= coursRepository.findById(c.getId()).get();
			cours.add(cour);
		}
		matieres.setCours(cours);
		MatiereEntity matiere= matiereRepository.save(modelMapperConverter.converToEntity(matieres, MatiereEntity.class));
	}
	public void updateMatiere(MatiereDTO matiere) {
		Optional<MatiereEntity> matiereUpdated = matiereRepository.findById(matiere.getId());
		MatiereEntity m = matiereUpdated.get();
		m.setCours(matiere.getCours());
		matiereRepository.save(m);
	}


}
