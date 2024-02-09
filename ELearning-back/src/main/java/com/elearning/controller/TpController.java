package com.elearning.controller;

import com.elearning.dto.TpDTO;
import com.elearning.entities.TpEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.service.ProfService;
import com.elearning.service.StorageService;
import com.elearning.serviceImpl.TpService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Files;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class TpController {
    @Autowired
    private TpService tpService;
    @Autowired
    private ProfService profService;
    @Autowired
    private ModelMapperConverter modelMapperConverter;
    @Autowired
    ServletContext context;
    @Autowired
    private StorageService storageService;
    @PostMapping("/tps")
    public ResponseEntity<TpEntity> createTp (
            @RequestParam("file") MultipartFile file,
            @RequestParam("tp") String tp
    ) throws JsonParseException, Exception {
        System.out.println("Ok .............");
        TpEntity tps = new ObjectMapper().readValue(tp, TpEntity.class);
        String newTpFile = storageService.addTpFile(file);
        tps.setTpFile(newTpFile);
        tpService.saveTp(tps);
        return ResponseEntity.status(HttpStatus.CREATED).body(tps);
    }
    @GetMapping("/tp")
    public ResponseEntity<List<TpEntity>> getAllTps() {
        return ResponseEntity.ok(tpService.getAll());
    }
    @GetMapping("tpdetail/{id}")
    public Optional<TpDTO> tpDetail(@PathVariable Long id) {
        System.out.println(id);
        Optional<TpDTO> tp = tpService.tpfindById(id);
        return tp;
    }
    @DeleteMapping("/tp/{id}")
    public void deleteTps(@PathVariable Long id) {
        tpService.deleteTp(id);
    }

    @GetMapping("/tp/{userId}")
    public ResponseEntity<List<TpDTO>> getTpByProfesseur(@PathVariable Long userId) {
        List<TpDTO> tps = tpService.getTpByUser(userId);
        return ResponseEntity.ok(tps);
    }
    @GetMapping("/tp/byProf")
    public ResponseEntity<List<TpDTO>> getTpsByProf(Principal principal) {
        String username= principal.getName();
        Optional<List<TpDTO>> tps = profService.findByProf(username);

        // Vérifiez si la liste est présente dans l'Optional
        if (tps.isPresent()) {
            return new ResponseEntity<>(tps.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/tp/{id}")
    public void update(@PathVariable long id, @RequestParam(value = "file", required = false) MultipartFile file,
                       @RequestParam("tp") String tp) throws Exception {
        TpEntity tps = new ObjectMapper().readValue(tp, TpEntity.class);
        deleteTpFile(tps);
        // System.out.println("hhhhhh" +file);

        if (file != null) {

            String newTpfile = storageService.addTpFile(file);
            tps.setTpFile(newTpfile);
        }
        tps.setId(id);
        tpService.update(tps);
    }
    @GetMapping(path = "/Tp/{id}")
    public ResponseEntity<byte[]> getTp(@PathVariable("id") Long id) throws Exception {
        System.out.println("Get all Tp ");
        TpDTO tp = tpService.tpfindById(id).get();

        String tpFile = tp.getTpFile();
        Optional<byte[]> bytes = Optional.empty();
        if (tpFile != null) {
            bytes = Optional.of(Files.readAllBytes(storageService.buildTpFile(tpFile)));
        }
        return  ResponseEntity.of(bytes);
    }
    private void deleteTpFile(TpEntity tp) {
        System.out.println(" Delete Tp ");
        try {
            File file = storageService.buildTpFile(tp.getTpFile()).toFile();
            System.out.println(tp.getTpFile());
            if (file.delete()) {
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Delete operation is failed.");
            }
        } catch (Exception e) {
            System.out.println("Failed to Delete document !!");
        }
    }
}
