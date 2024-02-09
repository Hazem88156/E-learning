package com.elearning.controller;

import com.elearning.config.JwtTokenProvider;
import com.elearning.domaine.Response;
import com.elearning.dto.prof.CreateProfDTO;
import com.elearning.entities.users.ProfEntity;
import com.elearning.service.ProfService;
import com.elearning.service.StorageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
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
public class ProfController {

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    ServletContext context;

    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    private ProfService profService;

    @Autowired
    private StorageService storageService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/prof")
    public ResponseEntity<Response> createUser(@RequestParam("file") MultipartFile file,
                                               @RequestParam("user") String user) throws JsonParseException, Exception {
        System.out.println("Ok .............");
        CreateProfDTO profs = new ObjectMapper().readValue(user, CreateProfDTO.class);
        String newImgfile = storageService.addUserImage(file);

       /* boolean isExit = new File(context.getRealPath("/Images/")).exists();
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


        profs.setImgfile(newImgfile);

        ProfEntity profExists = profService.findProfByLogin(profs.getEmail());
        if (profExists != null) {
            return new ResponseEntity<Response>(new Response("Email address already exist."), HttpStatus.BAD_REQUEST);
        } else {
            profService.addProf(profs);
            return new ResponseEntity<Response>(new Response(""), HttpStatus.CREATED);
        }
    }
    private void addUserImage(MultipartFile file) {
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit) {
            new File(context.getRealPath("/Images/")).mkdir();
            System.out.println("mk dir Imagess.............");
        }
        String imgfile = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(imgfile) + "." + FilenameUtils.getExtension(imgfile);
        File serverFile = new File(context.getRealPath("/Images/" + File.separator + newFileName));
        try {

            FileUtils.writeByteArrayToFile(serverFile, file.getBytes());

        } catch (Exception e) {
            System.out.println("Failed to Add Image User !!");
        }

    }

}
