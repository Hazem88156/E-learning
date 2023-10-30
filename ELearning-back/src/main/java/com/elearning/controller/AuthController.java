package com.elearning.controller;

import com.elearning.config.JwtTokenProvider;
import com.elearning.domaine.Response;
import com.elearning.dto.AuthenticateDTO;
import com.elearning.dto.ClasseDTO;
import com.elearning.dto.UserDTO;
import com.elearning.dto.UserDetailDTO;
import com.elearning.entities.ClasseEntity;
import com.elearning.entities.RoleEntity;
import com.elearning.entities.UserEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.UserRepository;
import com.elearning.serviceImpl.CustomUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    ServletContext context;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CustomUserDetailsService userService;

    /*
     * login authentication
     */
    @SuppressWarnings("rawtypes")
    @PostMapping("/login")
    public AuthenticateDTO login(@RequestBody AuthBody data) {
        AuthenticateDTO auth = new AuthenticateDTO();
        auth.setIsauthnenticate(false);
        try {
            //String username = data.getEmail();

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword()));
            String token = jwtTokenProvider.createToken(data.getEmail(), this.userRepository.findByEmail(data.getEmail()).getRoles());

            auth.setToken(token);
            auth.setUsername(data.getEmail());
            auth.setIsauthnenticate(true);
            UserEntity user = this.userRepository.findByEmail(data.getEmail());

            UserDTO userDto = new UserDTO();
            userDto.setFirstName(user.getFirstName());

            ClasseEntity classesEtudiant = user.getClassesEtudiant();
            if (classesEtudiant != null) {
                userDto.setClassesEtudiant(ModelMapperConverter.converToDTO(classesEtudiant, ClasseDTO.class));
            }
            System.out.println("classe" + classesEtudiant);
            System.out.println(userDto.getClassesEtudiant());
            userDto.setRoles(user.getRoles());
            userDto.setStatus(user.getStatus());
            userDto.setAddresse(user.getAddresse());
            userDto.setLastName(user.getLastName());
            userDto.setTelephone(user.getTelephone());
            userDto.setUsername(user.getUsername());
            userDto.setPassword(user.getPassword());
            userDto.setEmail(user.getEmail());
            userDto.setId(user.getId());
            userDto.setNcin(user.getNcin());
            userDto.setApropos(user.getApropos());
            auth.setUser(userDto);
            auth.setMessage("ok");
            System.out.println("\n\n\nauth" + auth.getToken());
            return auth;

        } catch (AuthenticationException e) {
            System.out.println("\n\n\nerreur de connexion");
            return auth;
        }

    }

    /*
     * register authentication
     */

    @SuppressWarnings("rawtypes")
    @PostMapping("/users")
    public ResponseEntity<Response> createUser(@RequestParam("file") MultipartFile file,
                                               @RequestParam("user") String user) throws JsonParseException, Exception {
        System.out.println("Ok .............");
        UserEntity users = new ObjectMapper().readValue(user, UserEntity.class);
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


        users.setImgfile(newImgfile);

        UserEntity userExists = userService.findUserByLogin(users.getEmail());
        if (userExists != null) {
            return new ResponseEntity<Response>(new Response("Email address already exist."), HttpStatus.BAD_REQUEST);
        } else {
            userService.saveUser(users);

            return new ResponseEntity<Response>(new Response(""), HttpStatus.CREATED);
        }
    }

    @PutMapping("/users/{id}")
    public void update(@PathVariable long id, @RequestParam(value = "file", required = false) MultipartFile file,
                       @RequestParam("user") String user) throws Exception {
        UserDetailDTO userr = new ObjectMapper().readValue(user, UserDetailDTO.class);
        deleteUserImage(userr);
        // System.out.println("hhhhhh" +file);

        if (file != null) {
            String imgfile = file.getOriginalFilename();
            String newImgfile = FilenameUtils.getBaseName(imgfile) + "." + FilenameUtils.getExtension(imgfile);
            userr.setImgfile(newImgfile);
            addUserImage(file);
            userr.setId(id);
            userService.update(userr);
        } else {
            userr.setId(id);
            userService.update(userr);
        }
    }

    @PutMapping("/updateEtudiant/{id}")
    public void updateEtudiant(@PathVariable long id, @RequestParam(value = "file", required = false) MultipartFile file,
                               @RequestParam("user") String user) throws Exception {
        UserEntity userr = new ObjectMapper().readValue(user, UserEntity.class);
        deleteEtudiantImage(userr);
        // System.out.println("hhhhhh" +file);

        if (file != null) {
            String imgfile = file.getOriginalFilename();
            String newImgfile = FilenameUtils.getBaseName(imgfile) + "." + FilenameUtils.getExtension(imgfile);
            userr.setImgfile(newImgfile);
            addUserImage(file);
            userr.setId(id);
            userService.updateEtudiant(userr);
        } else {
            userr.setId(id);
            userService.updateEtudiant(userr);
        }
    }

    @PutMapping("/userstatus/{id}")
    public void active(@PathVariable long id,
                       @RequestParam("user") String user) throws Exception {
        UserEntity userr = new ObjectMapper().readValue(user, UserEntity.class);
        userr.setId(id);
        userService.activer(userr);
    }


    @GetMapping(path = "/Images/{id}")
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception {
        System.out.println("Get all Users Images...");
        UserEntity User = userService.findById(id).get();
        return Files.readAllBytes(Paths.get(context.getRealPath("/Images/") + User.getImgfile()));
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

    private void deleteUserImage(UserDetailDTO user) {
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

    private void deleteEtudiantImage(UserEntity user) {
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

    @GetMapping("/users")
    public List<UserEntity> list() {
        System.out.println("Get all Users...");
        return userService.getAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserEntity> post(@PathVariable long id) {
        Optional<UserEntity> user = userService.findById(id);

        return user.map(ResponseEntity::ok)

                .orElseGet(() -> ResponseEntity.notFound()
                        .build());
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable long id) {
        userService.delete(id);
    }

    @GetMapping("/userstatusroles/{status}/{roles}")
    public List<UserDTO> getAllUser(@PathVariable String status, @PathVariable RoleEntity roles) {
        System.out.println("\n\n\n -+"
                + "select user avec condition roles et status");
        return userService.findByStatusAndRoles(status, roles);
    }

    @GetMapping("/usersss/{roles}")
    public List<UserDTO> getAllUsers(@PathVariable RoleEntity roles) {
        System.out.println("\n\n\n -+"
                + "	get user");
        return userService.findByRoles(roles);
    }

    @GetMapping("userdetail/{id}")
    public ResponseEntity<UserDTO> userDetail(@PathVariable Long id) {
        System.out.println(id);
        return ResponseEntity.of(userService.UserEntityById(id));
    }

    @DeleteMapping("deleteuser/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
