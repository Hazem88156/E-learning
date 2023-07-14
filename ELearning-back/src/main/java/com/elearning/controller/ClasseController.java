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
import com.elearning.dto.ClasseDTO;
import com.elearning.serviceImpl.ClasseService;
import com.elearning.serviceImpl.ClasseServiceImpl;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin(origins = "**")
@RestController
@RequestMapping("/api")
public class ClasseController {
	@Autowired
	private ClasseService classeService;
	@Autowired
	private ClasseServiceImpl classeServiceI;
	
	/*
	public ResponseEntity<List<ClasseDTO>> getAllClasses() {
		return ResponseEntity.ok(classeService.findAllClasses());
	}
	/*
	 * method to add user 
	 */
	/*
	@PostMapping("/classe")
    public ResponseEntity<ClasseDTO> create(@RequestBody ClasseDTO classeDTO) {
    	classeService.addClasse(classeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(classeDTO);
    }
	*/
	@PostMapping("/classes")
	 public ResponseEntity<ClasseDTO> createClasse (
			 @RequestParam("classe") String classe) throws JsonParseException , JsonMappingException , Exception
	 {
		 System.out.println("Ok .............");
       ClasseDTO classes = new ObjectMapper().readValue(classe, ClasseDTO.class);
       System.out.println(classe);
       System.out.println(classe);
       classeService.saveClasse(classes);
		
		return ResponseEntity.status(HttpStatus.CREATED).body( classes);
		
    
	 }
	@GetMapping("/classe")
	public ResponseEntity<List<ClasseDTO>> getAllClasses() {
		return ResponseEntity.ok(classeServiceI.findAllClasses());
	}
	/* @GetMapping("/classesss/{roles}")
		public List<UserEntity> getAllUsers(@PathVariable Long id) {
			System.out.println("\n\n\n -+"
					+ "	get user");
			return classeService.findById(id);
		}*/
	@PutMapping("/classesss/{id}")
    public void updateClasse(@PathVariable long id,
			 @RequestParam("classe") String classe) throws JsonParseException , JsonMappingException , Exception {
             ClasseDTO classes = new ObjectMapper().readValue(classe, ClasseDTO.class);
        	 classes.setId(id);
             classeService. updateClasse( classes);
        	 }
}

