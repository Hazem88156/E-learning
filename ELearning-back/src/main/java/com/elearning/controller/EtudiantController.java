package com.elearning.controller;

import com.elearning.config.JwtTokenProvider;
import com.elearning.domaine.Response;
import com.elearning.dto.etudiant.ClasseEtudiantDto;
import com.elearning.dto.etudiant.CreateEtudiantDTO;
import com.elearning.dto.etudiant.UpdateEtudiantDTO;
import com.elearning.entities.users.EtudiantEntity;
import com.elearning.service.EtudiantService;
import com.elearning.service.StorageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;

@CrossOrigin()
@RestController
@RequestMapping("/api/auth")
public class EtudiantController {

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    ServletContext context;

    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    private EtudiantService etudiantService;
    @Autowired
    private StorageService storageService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/etudiant")
    public ResponseEntity<Response> createUser(@RequestParam("file") MultipartFile file,
                                               @RequestParam("user") String user) throws JsonParseException, Exception {
        System.out.println("Ok .............");
        CreateEtudiantDTO etudiants = new ObjectMapper().readValue(user, CreateEtudiantDTO.class);
        String newImgfile = storageService.addUserImage(file);

        /*boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit) {
            new File(context.getRealPath("/Images/")).mkdir();
            System.out.println("mkdir.............");
        }
        String imgfile = file.getOriginalFilename();
        String newImgfile = FilenameUtils.getBaseName(imgfile) + "." + FilenameUtils.getExtension(imgfile);

        File serverFile = new File(context.getRealPath("/Images/" + File.separator + newImgfile));
        try {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile, file.getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }*/


        etudiants.setImgfile(newImgfile);

        EtudiantEntity etudiantExists = etudiantService.findEtudiantByLogin(etudiants.getEmail());
        if (etudiantExists != null) {
            return new ResponseEntity<Response>(new Response("Email address already exist."), HttpStatus.BAD_REQUEST);
        } else {
            etudiantService.addEtudiant(etudiants);
            return new ResponseEntity<Response>(new Response(""), HttpStatus.CREATED);
        }
    }

    @PutMapping("/updateEtudiant/{id}")
    public void updateEtudiant(@PathVariable long id,
                               @RequestParam(value = "file", required = false) MultipartFile file,
                               @RequestParam("user") String user) throws Exception {
        UpdateEtudiantDTO etudiantDTO = new ObjectMapper().readValue(user, UpdateEtudiantDTO.class);
        deleteUserImage(etudiantDTO);

        if (file != null) {
            String newImgfile = storageService.addUserImage(file);
            etudiantDTO.setImgfile(newImgfile);
            etudiantService.updateEtudiant(id, etudiantDTO);
        } else {
            etudiantService.updateEtudiant(id, etudiantDTO);
        }
    }
    private void deleteUserImage(UpdateEtudiantDTO user) {
        System.out.println(" Delete User Image");
        try {
            File file = new File(context.getRealPath("/ImgUsers/" + user.getImgfile()));
            System.out.println(user.getImgfile());
            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Delete operation is failed.");
            }
        } catch (Exception e) {
            System.out.println("Failed to Delete image !!");
        }
    }

    @GetMapping("/etudiant/{id}/classe")
    public ResponseEntity<ClasseEtudiantDto> getClasseByEtudiantId(@PathVariable Long id){
        return ResponseEntity.of(etudiantService.getClasseByEtudiantId(id));
    }
}
