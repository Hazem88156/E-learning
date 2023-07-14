	package com.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.elearning.dto.CoursDTO;
import com.elearning.entities.CoursEntity;
import com.elearning.serviceImpl.CoursService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "**")
@RestController
@RequestMapping("/api")
public class CoursController {
	@Autowired
	private CoursService coursService;
	
	@PostMapping("/cours")
	 public ResponseEntity<CoursEntity> createClasse (
			 @RequestParam("cours") String cours) throws JsonParseException , JsonMappingException , Exception
	 {
		 System.out.println("Ok .............");
      CoursEntity cour = new ObjectMapper().readValue(cours, CoursEntity.class);
      
      coursService.saveCours(cour);
		
		return ResponseEntity.status(HttpStatus.CREATED).body( cour);
		
   
	 }
	@GetMapping("/cour")
	public ResponseEntity<List<CoursEntity>> getAllCours() {
		return ResponseEntity.ok(coursService.getAll());
	}
	@PutMapping("/courss/{id}")
    public void updateClasse(@PathVariable Long id,
			 @RequestParam("cour") String cour) throws JsonParseException , JsonMappingException , Exception {
			System.out.println(id);
             CoursEntity cours = new ObjectMapper().readValue(cour, CoursEntity.class);
        	 cours.setId(id);
             coursService. update( cours);
        	 }
	@GetMapping("coursdetail/{id}")
    public CoursDTO courDetail(@PathVariable Long id) {
  	  System.out.println(id);
	        CoursDTO cour = coursService.CoursById(id);
	        System.out.println("documents"+cour.getDocuments());
	        return cour;
	    }
	@GetMapping("/cour/user/{userId}")
    public List<CoursEntity> getCoursByUser(@PathVariable Long userId) {
        return coursService.CoursByUser(userId);
    }
	@GetMapping("/cour/classe/{classeId}")
    public List<CoursEntity> getCoursByClasse(@PathVariable Long classeId) {
		
        return coursService.CoursByClasse(classeId);
    }


}
