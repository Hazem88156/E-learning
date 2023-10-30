package com.elearning.controller;

import com.elearning.dto.CoursDTO;
import com.elearning.entities.CoursEntity;
import com.elearning.exceptions.CoursNameAlreadyExist;
import com.elearning.serviceImpl.CoursService;
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
public class CoursController {
    @Autowired
    private CoursService coursService;

    @PostMapping("/cours")
    public ResponseEntity<CoursDTO> createCours(
            @RequestParam("cours") String cours) throws JsonParseException, JsonMappingException, Exception {
        System.out.println("Ok .............");
        CoursDTO courDto = new ObjectMapper().readValue(cours, CoursDTO.class);
        try {
            Optional<CoursDTO> courDtoOptional = coursService.saveCours(courDto);
            return ResponseEntity.of(courDtoOptional);
        } catch (CoursNameAlreadyExist e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }

    @GetMapping("/cour")
    public ResponseEntity<List<CoursDTO>> getAllCours() {
        return ResponseEntity.ok(coursService.getAll());
    }

    @PutMapping("/courss/{id}")
    public void updateClasse(@PathVariable Long id,
                             @RequestParam("cour") String cour) throws JsonParseException, JsonMappingException, Exception {
        System.out.println(id);
        CoursEntity cours = new ObjectMapper().readValue(cour, CoursEntity.class);
        cours.setId(id);
        coursService.update(cours);
    }

    @GetMapping("coursdetail/{id}")
    public CoursDTO courDetail(@PathVariable Long id) {
        System.out.println(id);
        CoursDTO cour = coursService.CoursById(id);
        // System.out.println("documents"+cour.getDocuments());
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

    @DeleteMapping("/cour/{id}")
    public void deleteCours(@PathVariable Long id) {
        coursService.deleteCours(id);
    }

}
