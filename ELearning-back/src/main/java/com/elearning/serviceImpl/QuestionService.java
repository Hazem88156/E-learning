package com.elearning.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.entities.QuestionEntity;
import com.elearning.repository.QuestionRepository;

@Service
@Transactional
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	
     public void saveQuestion(QuestionEntity question) {
		
        questionRepository.save(question);
	}
	public List<QuestionEntity> getAll() {
		System.out.println("Get all Cours 11111...");
		return questionRepository.findAll();
	}
	public Optional<QuestionEntity> questionfindById(long id) {
		// TODO Auto-generated method stub
		return questionRepository.findById(id);
	}


}
