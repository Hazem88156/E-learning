package com.elearning.controller;


import com.elearning.dto.ClasseDTO;
import com.elearning.entities.ClasseEntity;
import com.elearning.service.ClasseService;
import com.elearning.serviceImpl.ClasseServiceImpl;
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
@RequestMapping("/api/classe")
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
    @PostMapping()
    public ResponseEntity<ClasseDTO> createClasse(@RequestParam("classe") String classe) throws JsonParseException, JsonMappingException, Exception {
        System.out.println("Ok .............");
        ClasseDTO classes = new ObjectMapper().readValue(classe, ClasseDTO.class);

        System.out.println(classe);
        classeService.saveClasse(classes);

        return ResponseEntity.status(HttpStatus.CREATED).body(classes);


    }

    @GetMapping()
    public ResponseEntity<List<ClasseDTO>> getAllClasses() {
        return ResponseEntity.ok(classeServiceI.findAllClasses());
    }

    /* @GetMapping("/classesss/{roles}")
        public List<UserEntity> getAllUsers(@PathVariable Long id) {
            System.out.println("\n\n\n -+"
                    + "	get user");
            return classeService.findById(id);
        }*/
    @PutMapping("{id}")
    public ResponseEntity<ClasseDTO> updateClasse(@PathVariable long id, @RequestParam("classe") String classeString) throws JsonParseException, JsonMappingException, Exception {
        ClasseDTO classe = new ObjectMapper().readValue(classeString, ClasseDTO.class);
        classe.setId(id);
        Optional<ClasseDTO> optionalClasseDTO = classeServiceI.updateClasse(classe);
        return ResponseEntity.of(optionalClasseDTO);
    }
    @DeleteMapping("{id}")
    public void deleteClasse(@PathVariable Long id) {
        classeService.deleteClasse(id);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClasseEntity> classeDetail(@PathVariable Long id) {
        System.out.println(id);
        Optional<ClasseEntity> classe = classeService.findById(id);
        return ResponseEntity.of(classe);
    }
}

