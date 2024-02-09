package com.elearning.controller;

import com.elearning.dto.ReunionDTO;
import com.elearning.entities.ReunionEntity;
import com.elearning.serviceImpl.ReunionService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin()
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
	@PutMapping("/reunion/{id}")
	public void update(@PathVariable long id ,
					   @RequestParam("reunion") String reunion) throws Exception {
		ReunionEntity reunions = new ObjectMapper().readValue(reunion, ReunionEntity.class);
		reunions.setId(id);
		reunionService.update(reunions);
	}
	@GetMapping("/reunion/{userId}")
	public ResponseEntity<List<ReunionDTO>> getReunionsByProfesseur(@PathVariable Long userId) {
		List<ReunionDTO> reunions = reunionService.getReunionsByUser(userId);
		return ResponseEntity.ok(reunions);
	}
	@GetMapping("/reuniondetail/{id}")
	public Optional<ReunionDTO> reunionDetail(@PathVariable Long id) {
		System.out.println(id);
		Optional<ReunionDTO> reunion = reunionService.findReunionById(id);
		return reunion;
	}

}
