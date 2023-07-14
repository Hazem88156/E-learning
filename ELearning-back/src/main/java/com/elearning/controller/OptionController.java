package com.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.elearning.entities.OptionEntity;
import com.elearning.serviceImpl.OptionService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "**")
@RestController
@RequestMapping("/api")
public class OptionController {
	@Autowired
	private OptionService optionService;
	
	@PostMapping("/options")
	 public ResponseEntity<OptionEntity> createOption (
			 @RequestParam("option") String options) throws JsonParseException , JsonMappingException , Exception
	 {
		 System.out.println("Ok .............");
      OptionEntity option = new ObjectMapper().readValue(options, OptionEntity.class);
      
      optionService.saveOption(option);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(option);
		
   
	 }
	@GetMapping("/option")
	public ResponseEntity<List<OptionEntity>> getAllOption() {
		return ResponseEntity.ok(optionService.getAll());
	}
	
	

}
