package com.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.entities.ExamenEntity;
import com.elearning.entities.QuestionEntity;
import com.elearning.serviceImpl.ExamenService;
import com.elearning.serviceImpl.QuestionService;

@RestController
@CrossOrigin()
@RequestMapping("/api")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	@PostMapping(value="question", consumes = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<QuestionEntity> createQuestion (
			 @RequestBody QuestionEntity question) //throws JsonParseException , JsonMappingException , Exception
	 {
		 System.out.println("Ok .............");
     //QuestionEntity question = new ObjectMapper().readValue(questions, QuestionEntity.class);
     
     questionService.saveQuestion(question);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(question);
		
  
	 }

}
