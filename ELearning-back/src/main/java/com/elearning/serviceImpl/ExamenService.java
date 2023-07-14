package com.elearning.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.dto.CoursDTO;
import com.elearning.entities.CoursEntity;
import com.elearning.entities.ExamenEntity;
import com.elearning.entities.QuestionEntity;
import com.elearning.entities.VedioEntity;
import com.elearning.repository.CoursRepository;
import com.elearning.repository.ExamenRepository;
import com.elearning.repository.QuestionRepository;

@Service

public class ExamenService {
	@Autowired
	private ExamenRepository examenRepository;
	@Autowired
	private CoursRepository coursRepository;
	@Autowired
	private QuestionRepository questionRepository;
	
     public ExamenEntity saveExamen(ExamenEntity examen) {
    	 List<QuestionEntity> questions = examen.getQuestions();
    	 examen.setQuestions(new ArrayList<>());
    	 examenRepository.save(examen);
    	 for (QuestionEntity question : questions ) {
    		 question.setExamen(examen);
    		 questionRepository.save(question);
         }
    	 System.out.println("examen"+examen.getQuestions());
    	 examen.setQuestions(questions);
    	 return examen;
    	 
	}
	public List<ExamenEntity> getAll() {
		System.out.println("Get all Cours 11111...");
		return examenRepository.findAll();
	}
	public Optional<ExamenEntity> examenfindById(long id) {
		// TODO Auto-generated method stub
		return examenRepository.findById(id);
	}
	@Transactional
	public void update(ExamenEntity examen) {
		// TODO Auto-generated method stub
		System.out.println(examen);
		Optional<ExamenEntity> examenUpdated = examenRepository.findById(examen.getId());
		ExamenEntity e = examenUpdated.get();
		
		e.setExamenName(examen.getExamenName());
		e.setQuestions(examen.getQuestions());
		
		
		examenRepository.save(e);
		}
	public ExamenEntity ExamenById(Long id) {
		// TODO Auto-generated method stub
		ExamenEntity examen = examenRepository.findById(id).get();
		System.out.println(examen+"jjjjjjjj");
		return examen;
		
		
	}
	 public List<ExamenEntity> getExamenByCoursId(Long id) {
	 	    CoursEntity cours = coursRepository.findById(id).orElse(null);
	 	    if (cours != null) {
	 	        List<ExamenEntity> examens = cours.getExamens();
	 	        return examens;
	 	    }
	 	    return new ArrayList<>();
	 	}

}
