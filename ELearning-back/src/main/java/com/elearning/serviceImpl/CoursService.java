package com.elearning.serviceImpl;

import com.elearning.dto.CoursDTO;
import com.elearning.entities.ClasseEntity;
import com.elearning.entities.CoursEntity;
import com.elearning.entities.users.ProfEntity;
import com.elearning.exceptions.CoursNameAlreadyExist;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.ClasseRepository;
import com.elearning.repository.CoursRepository;
import com.elearning.repository.users.EtudiantRepository;
import com.elearning.repository.users.ProfRepository;
import com.elearning.repository.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoursService {
    @Autowired
    private ModelMapperConverter modelMapperConverter;
    @Autowired
    private CoursRepository coursRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfRepository profRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;
    @Autowired
    private ClasseRepository classeRepository;

    public Optional<CoursDTO> saveCours(CoursDTO cours) throws CoursNameAlreadyExist {
        if (coursRepository.existsByNomCours(cours.getNomCours())){
            throw new CoursNameAlreadyExist();
        }
        CoursEntity coursEntity = ModelMapperConverter.converToEntity(cours, CoursEntity.class);
        coursRepository.save(coursEntity);
        return Optional.of(ModelMapperConverter.converToDTO(coursEntity, CoursDTO.class));
    }

    public List<CoursDTO> getAll() {
        // TODO Auto-generated method stub
        return coursRepository.findAll().stream()
                .map(coursEntity -> ModelMapperConverter.converToDTO(coursEntity, CoursDTO.class))
                .collect(Collectors.toList());
    }

    public void update(CoursEntity cour) {
        // TODO Auto-generated method stub
        System.out.println(cour);
        Optional<CoursEntity> courUpdated = coursRepository.findById(cour.getId());
        CoursEntity c = courUpdated.get();
        c.setHeureDebut(cour.getHeureDebut());
        c.setHeureFin(cour.getHeureFin());
        c.setUser(cour.getUser());
        if (cour.getCoursFile()!= null) {
            c.setCoursFile(cour.getCoursFile());
        }
        c.setClasse(cour.getClasse());
        c.setMatiere(cour.getMatiere());
        c.setNomCours(cour.getNomCours());
        c.setDate(cour.getDate());
        coursRepository.save(c);
    }

    public CoursDTO CoursById(Long id) {
        // TODO Auto-generated method stub
        CoursEntity cour = coursRepository.findById(id).get();
        System.out.println(cour + "jjjjjjjj");
        return modelMapperConverter.converToDTO(cour, CoursDTO.class);


    }


    public List<CoursDTO> CoursByUser(Long userId) {
        Optional<ProfEntity> userOptional = profRepository.findById(userId);
        if (userOptional.isPresent()) {
            ProfEntity prof = userOptional.get();
            List<CoursDTO> coursDTOList = prof.getCours().stream()
                    .map(coursEntity -> ModelMapperConverter.converToDTO(coursEntity, CoursDTO.class))
                    .collect(Collectors.toList());
            return coursDTOList;
        }
        return Collections.emptyList();
    }
    public List<CoursEntity> CoursByClasse(Long classeId) {
        Optional<ClasseEntity> classeOptional = classeRepository.findById(classeId);
        if (classeOptional.isPresent()) {
            ClasseEntity classe = classeOptional.get();
            return classe.getCours();
        }

        return Collections.emptyList();
    }

    /*public List<DocumentEntity> getDocumentsByCoursId(Long id) {
           CoursEntity cours = coursRepository.findById(id).orElse(null);
           if (cours != null) {
               List<DocumentEntity> documents = cours.getDocuments();
               return documents;
           }
           return new ArrayList<>();
       }*/
     /*public List<VedioEntity> getVediosByCoursId(Long id) {
 	    CoursEntity cours = coursRepository.findById(id).orElse(null);
 	    if (cours != null) {
 	        List<VedioEntity> vedios = cours.getVedios();
 	        return vedios;
 	    }
 	    return new ArrayList<>();
 	}*/
    public void deleteCours(Long id) {
        coursRepository.deleteById(id);
    }

//    public List<CoursEntity> getCoursesForClass(Long classId) {
//        List<CoursEntity> cours = coursRepository.findByClasseId(classId);
//
//        return st.stream()
//                .flatMap(student -> student.getCourses().stream())
//                .distinct()
//                .collect(Collectors.toList());
//    }
}
		


