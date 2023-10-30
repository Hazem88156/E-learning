package com.elearning.serviceImpl;

import com.elearning.dto.MatiereDTO;
import com.elearning.entities.MatiereEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.ClasseRepository;
import com.elearning.repository.MatiereRepository;
import com.elearning.service.MatiereService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MatiereServiceImpl implements MatiereService{
	private final MatiereRepository matiereRepository;
	private final ClasseRepository classeRepository;

	public MatiereServiceImpl(MatiereRepository matiereRepository, ClasseRepository classeRepository) {
		this.matiereRepository = matiereRepository;
		this.classeRepository = classeRepository;
	}

	@Override
	public List<MatiereDTO> findAllMatieres() {
		return ModelMapperConverter.convertAllToDTO(matiereRepository.findAll(), MatiereDTO.class);
	}
	@Override
	public MatiereDTO saveMatiere(MatiereDTO matiereDTO) {

		MatiereEntity matiereEntity = matiereRepository.save(ModelMapperConverter.converToEntity(matiereDTO, MatiereEntity.class));
		// Ajouter la classe
		matiereRepository.save(matiereEntity);
		return ModelMapperConverter.converToDTO(matiereEntity, MatiereDTO.class);
		
	}

	@Override
	public Optional<MatiereDTO> updateMatiere(Long id, MatiereDTO matiereDTO) {
		if (!matiereRepository.existsById(id)){
			return Optional.empty();
		}
		MatiereEntity matiereEntity = matiereRepository.getById(matiereDTO.getId());
		matiereEntity.setNomMatiere(matiereDTO.getNomMatiere());
		matiereEntity.setCoeif(matiereDTO.getCoeif());
		matiereEntity.setNbHeure(matiereDTO.getNbHeure());
		matiereRepository.save(matiereEntity);
		return Optional.of(
				ModelMapperConverter.converToDTO(matiereEntity, MatiereDTO.class)
		);
	}

	@Override
	public void deleteMatiere(Long id) {
		matiereRepository.deleteById(id);
	}
	public Optional<MatiereEntity> findById(long id) {
		// TODO Auto-generated method stub
		return matiereRepository.findById(id);
	}


}
