package com.elearning.serviceImpl;


import com.elearning.dto.ClasseDTO;
import com.elearning.entities.ClasseEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.ClasseRepository;
import com.elearning.repository.MatiereRepository;
import com.elearning.repository.users.EtudiantRepository;
import com.elearning.repository.users.UserRepository;
import com.elearning.service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClasseServiceImpl implements ClasseService {
    @Autowired
    private ClasseRepository classeRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;
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
    public void saveClasse(ClasseDTO classes) {

//		List<MatiereEntity> matieres = new ArrayList<>() ;
//
//
//		for (MatiereEntity m : classes.getMatieres() ) {
//			MatiereEntity matiere = matiereRepository.findById(m.getId()).get();
//			matieres.add(matiere);
//		}
//		classes.setMatieres(matieres);

        ClasseEntity classeEntity = modelMapperConverter.converToEntity(classes, ClasseEntity.class);
        ClasseEntity classe = classeRepository.save(classeEntity);


    }

    @Override
    public Optional<ClasseDTO> updateClasse(ClasseDTO classeDTO) {
        boolean classeExistsedById = classeRepository.existsById(classeDTO.getId());
        if (!classeExistsedById) {
            return Optional.empty();
        }
        ClasseEntity classeEntity = classeRepository.getById(classeDTO.getId());
        classeEntity.setNomClasse(classeDTO.getNomClasse());
        classeEntity.setAnnee(classeDTO.getAnnee());
        classeEntity.setSection(classeDTO.getSection());
        classeRepository.save(classeEntity);
        return Optional.of(
                ModelMapperConverter.converToDTO(classeEntity, ClasseDTO.class)
        );
    }

    @Override
    public void deleteClasse(Long id) {
        classeRepository.deleteById(id);
    }

    public Optional<ClasseEntity> findById(Long id) {
        System.out.println("Get classe by id...");
        return classeRepository.findById(id);
    }

    @Override
    public Optional<ClasseEntity> getClasseByEtudinat(Long etudiantId) {
        return Optional.empty();
    }

}
