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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.dto.ClasseDTO;
import com.elearning.entities.ReunionEntity;
import com.elearning.serviceImpl.ReunionService;
import com.elearning.serviceImpl.VedioService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "**")
@RestController
@RequestMapping("/api")
public class ReunionController {
	@Autowired
	private ReunionService reunionService;
	
	@PostMapping("/reunions")
	 public ResponseEntity<ReunionEntity> createReunion (
			 @RequestParam("reunion") String reunion) throws JsonParseException , JsonMappingException , Exception
	 {
		 System.out.println("Ok .............");
      ReunionEntity reunions = new ObjectMapper().readValue(reunion, ReunionEntity.class);
      System.out.println(reunion);
      System.out.println(reunion);
      reunionService.saveReunions(reunions);
		
		return ResponseEntity.status(HttpStatus.CREATED).body( reunions);
		
   
	 }
	@GetMapping("/reunion")
	public ResponseEntity<List<ReunionEntity>> getAllReunions() {
		return ResponseEntity.ok(reunionService.getAll());
	}
	 @GetMapping("/reuniono/{id}")
	    public ResponseEntity<ReunionEntity> getReunionById(@PathVariable("id") Long id) {
	        ReunionEntity reunion = reunionService.getReunionById(id);
	        
	        if (reunion != null) {
	            return new ResponseEntity<>(reunion, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

}
