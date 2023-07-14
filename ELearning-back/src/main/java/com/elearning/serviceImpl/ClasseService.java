package com.elearning.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elearning.dto.ClasseDTO;
import com.elearning.entities.ClasseEntity;
import com.elearning.entities.MatiereEntity;
import com.elearning.entities.UserEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.ClasseRepository;
import com.elearning.repository.MatiereRepository;
import com.elearning.repository.UserRepository;


@Service
public class ClasseService {
	@Autowired
	private ClasseRepository classeRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MatiereRepository matiereRepository;
	@Autowired
	private ModelMapperConverter modelMapperConverter;
	public void saveClasse(ClasseDTO classes) {
		List<UserEntity> users = new ArrayList<>() ;
		List<MatiereEntity> matieres = new ArrayList<>() ;
		System.out.println(classes.getUsers());
		
		for (MatiereEntity m : classes.getMatieres() ) {
			MatiereEntity matiere = matiereRepository.findById(m.getId()).get();
			matieres.add(matiere);
		}
		for (UserEntity u : classes.getUsers() ) {
			UserEntity user = userRepository.findById(u.getId()).get();
			users.add(user);
		}
		classes.setUsers(users);
		classes.setMatieres(matieres);
		ClasseEntity classe= classeRepository.save(modelMapperConverter.converToEntity(classes, ClasseEntity.class));

		
	}
	
	public void updateClasse(ClasseDTO classe) {
		Optional<ClasseEntity> classeUpdated = classeRepository.findById(classe.getId());
		ClasseEntity c = classeUpdated.get();
		c.setNomClasse(classe.getNomClasse());
		c.setMatieres(classe.getMatieres());
		c.setUsers(classe.getUsers());
		classeRepository.save(c);
	}
}
