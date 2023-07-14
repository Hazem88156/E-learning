package com.elearning.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elearning.entities.ReunionEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.ReunionRepository;

@Service
public class ReunionService {
	
	@Autowired
	private ModelMapperConverter modelMapperConverter;
	@Autowired
	private ReunionRepository reunionsRepository;
	
     public void saveReunions(ReunionEntity reunion) {
		reunionsRepository.save(reunion);
	}
	
	public List<ReunionEntity> getAll() {
		System.out.println("Get all Reunions 11111...");
		return reunionsRepository.findAll();
	}
	public ReunionEntity getReunionById(Long id) {
        // Logique de récupération de réunion
        
        return reunionsRepository.findById(id).orElse(null);
    }

}
