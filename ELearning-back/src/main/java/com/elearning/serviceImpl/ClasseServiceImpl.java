package com.elearning.serviceImpl;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dto.ClasseDTO;
import com.elearning.entities.ClasseEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.ClasseRepository;
import com.elearning.repository.MatiereRepository;
import com.elearning.repository.UserRepository;
import com.elearning.service.ClasseService;

@Service
@Transactional
public class ClasseServiceImpl implements ClasseService{
	@Autowired
	private ClasseRepository classeRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MatiereRepository matiereRepository;
	@Autowired
	private ModelMapperConverter modelMapperConverter;

	@Override
	public List<ClasseDTO> findAllClasses() {
		List<ClasseEntity> classes = classeRepository.findAll();
		return modelMapperConverter.convertAllToDTO(classes, ClasseDTO.class);
	}

	@Override
	public void addClasse(ClasseDTO classe) {
		classeRepository.save(modelMapperConverter.converToEntity(classe, ClasseEntity.class));
		
	}
	public Optional<ClasseEntity> findById(Long id){
		System.out.println("Get classe by id...");
		return classeRepository.findById(id);
	}

}
