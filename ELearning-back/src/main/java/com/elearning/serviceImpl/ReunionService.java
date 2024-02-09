package com.elearning.serviceImpl;

import com.elearning.dto.ReunionDTO;
import com.elearning.entities.ReunionEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.ReunionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReunionService {
	
	@Autowired
	private ModelMapperConverter modelMapperConverter;
	@Autowired
	private ReunionRepository reunionsRepository;
	
     public void saveReunions(ReunionEntity reunion) {
		reunionsRepository.save(reunion);
	}

	public List<ReunionDTO> getReunionsByUser(Long userId) {
		List<ReunionEntity> reunions = reunionsRepository.findByCourUserId(userId);
		return ModelMapperConverter.convertAllToDTO(reunions, ReunionDTO.class);
	}
	public Optional<ReunionDTO> findReunionById(long id) {
		// TODO: implémenter la logique pour rechercher un document par son ID
		Optional<ReunionEntity> reunion = reunionsRepository.findById(id);

		return reunion.map(reunionEntity -> ModelMapperConverter.converToDTO(reunionEntity, ReunionDTO.class));
	}

	public void update(ReunionEntity reunion) {
		// TODO Auto-generated method stub
		System.out.println(reunion);
		Optional<ReunionEntity> reunionUpdated = reunionsRepository.findById(reunion.getId());
		ReunionEntity r= reunionUpdated.get();
		r.setReunionName(reunion.getReunionName());
		r.setCour(reunion.getCour());
		reunionsRepository.save(r);
	}

}
