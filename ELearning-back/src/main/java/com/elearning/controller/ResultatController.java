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
import com.elearning.entities.ResultatEntity;
import com.elearning.serviceImpl.ResultatService;

@CrossOrigin(origins = "**")
@RestController
@RequestMapping("/api")
public class ResultatController {
    
	@Autowired
	private ResultatService resultatService;
	
	@PostMapping(value="resultat", consumes = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<ResultatEntity> createResultat (
			 @RequestBody ResultatEntity resultat) //throws JsonParseException , JsonMappingException , Exception
	 {
		 System.out.println("Ok .............");  
		 resultat = resultatService.saveResultat(resultat);	
		return ResponseEntity.status(HttpStatus.CREATED).body(resultat);
	 }
	
}
