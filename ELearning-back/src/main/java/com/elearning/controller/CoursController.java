package com.elearning.controller;

import com.elearning.dto.CoursDTO;
import com.elearning.entities.CoursEntity;
import com.elearning.exceptions.CoursNameAlreadyExist;
import com.elearning.service.StorageService;
import com.elearning.serviceImpl.CoursService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class CoursController {
    @Autowired
    private CoursService coursService;
    @Autowired
    private StorageService storageService;
    @PostMapping("/cours")
    public ResponseEntity<CoursDTO> createCours(
             @RequestParam("cours") String cours, @RequestParam("file") MultipartFile file) throws JsonParseException, JsonMappingException, Exception {
        System.out.println("Ok .............");
        CoursDTO courDto = new ObjectMapper().readValue(cours, CoursDTO.class);
        String newCoursFile;
        newCoursFile = storageService.addUserImage(file);
        courDto.setCoursFile(newCoursFile);
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
                             @RequestParam("cour") String cour,@RequestParam(value = "file", required = false) MultipartFile file) throws JsonParseException, JsonMappingException, Exception {
        System.out.println(id);
        CoursEntity cours = new ObjectMapper().readValue(cour, CoursEntity.class);
        deleteCoursFile(cours);
        if (file != null) {
//            String imgfile = file.getOriginalFilename();
//            String newImgfile = FilenameUtils.getBaseName(imgfile) + "." + FilenameUtils.getExtension(imgfile);
            //            userr.setImgfile(newImgfile);
            // String newImgfile = addUserImage(file);
            String newCoursfile = storageService.addCoursFile(file);
            cours.setCoursFile(newCoursfile);
        }
        cours.setId(id);
        coursService.update(cours);
    }
    private void deleteCoursFile(CoursEntity cours) {
        System.out.println(" Delete Document ");
        try {
            File file = storageService.buildCoursFile(cours.getCoursFile()).toFile();
            System.out.println(cours.getCoursFile());
            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Delete operation is failed.");
            }
        } catch (Exception e) {
            System.out.println("Failed to Delete document !!");
        }
    }
    @GetMapping(path = "/Cours/{id}")
    public ResponseEntity<byte[]> getPhoto(@PathVariable("id") Long id) throws Exception {
        System.out.println("Get all Document ");
        CoursDTO Cours = coursService.CoursById(id);

        String coursFile = Cours.getCoursFile();
        Optional<byte[]> bytes = Optional.empty();
        if (coursFile != null) {
            bytes = Optional.of(Files.readAllBytes(storageService.buildCoursFile(coursFile)));
        }
        return  ResponseEntity.of(bytes);
    }

    @GetMapping("coursdetail/{id}")
    public CoursDTO courDetail(@PathVariable Long id) {
        System.out.println(id);
        CoursDTO cour = coursService.CoursById(id);
        return cour;
    }
   @GetMapping("/cour/user/{userId}")
    public List<CoursDTO> getCoursByUser(@PathVariable Long userId) {
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
