package com.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.dto.DocumentDTO;
import com.elearning.dto.ExamenDTO;
import com.elearning.entities.DocumentEntity;
import com.elearning.entities.ExamenEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.serviceImpl.ExamenService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin(origins = "**")
@RestController
@RequestMapping("/api")
public class ExamenController {
	
	@Autowired
	private ExamenService examenService;
	@Autowired
	private ModelMapperConverter modelMapperConverter;
	
	@PostMapping(value="examen", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
	 public ResponseEntity<ExamenEntity> createExamen (
			 @RequestBody ExamenEntity examen) //throws JsonParseException , JsonMappingException , Exception
	 {
		 System.out.println("Ok .............");
      //QuestionEntity question = new ObjectMapper().readValue(questions, QuestionEntity.class);
      
		 examen = examenService.saveExamen(examen);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(examen);
		
   
	 }
	@GetMapping("examen")
	public ResponseEntity<List<ExamenEntity>> getAllExamen() {
		return ResponseEntity.ok(examenService.getAll());
	}
	@PutMapping("/examen/{id}")
    public void updateClasse(@PathVariable Long id,
			 @RequestParam("examen") String examen) throws JsonParseException , JsonMappingException , Exception {
			System.out.println(id);
             ExamenEntity examens = new ObjectMapper().readValue(examen, ExamenEntity.class);
        	 examens.setId(id);
             examenService. update( examens);
        	 }
	
	@GetMapping("examendetail/{id}")
    public ExamenEntity examenDetail(@PathVariable Long id) {
  	  System.out.println(id);
	        ExamenEntity examen = examenService.ExamenById(id);
	        return examen;
	    }
	@GetMapping("/examens/cours/{courId}")
	public ResponseEntity<List<ExamenDTO>> getExamensByCours(@PathVariable Long courId) {
		System.out.println("Liste de examens pour le cours " + courId);
	    List<ExamenEntity> examens = examenService.getExamenByCoursId(courId);
	    List<ExamenDTO>examenss=modelMapperConverter.convertAllToDTO(examens,ExamenDTO.class);
	    System.out.println(examenss);
	    return ResponseEntity.ok(examenss);
	}
}
