package com.elearning.controller;

import com.elearning.config.JwtTokenProvider;
import com.elearning.domaine.Response;
import com.elearning.dto.admin.CreateAdminDTO;
import com.elearning.entities.users.AdminEntity;
import com.elearning.service.AdminService;
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
public class AdminController {

    @Autowired
    AuthenticationManager authenticationManager;


    @Autowired
    ServletContext context;

    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AdminService adminService;

    @SuppressWarnings("rawtypes")
    @PostMapping("/admin")
    public ResponseEntity<Response> createUser(@RequestParam("file") MultipartFile file,
                                               @RequestParam("user") String user) throws JsonParseException, Exception {
        System.out.println("Ok .............");
        CreateAdminDTO admins = new ObjectMapper().readValue(user, CreateAdminDTO.class);
        addUserImage(file);
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
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
        }


        admins.setImgfile(newImgfile);

        AdminEntity adminExists = adminService.findAdminByLogin(admins.getEmail());
        if (adminExists != null) {
            return new ResponseEntity<Response>(new Response("Email address already exist."), HttpStatus.BAD_REQUEST);
        } else {
            adminService.addAdmin(admins);
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
