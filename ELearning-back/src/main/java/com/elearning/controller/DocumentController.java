package com.elearning.controller;

import com.elearning.dto.DocumentDTO;
import com.elearning.entities.DocumentEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.service.StorageService;
import com.elearning.serviceImpl.DocumentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin()
@RequestMapping("/api")
public class DocumentController {
    @Autowired
    private ModelMapperConverter modelMapperConverter;
    @Autowired
    private DocumentServiceImpl documentService;
    @Autowired
    ServletContext context;
    @Autowired
    private StorageService storageService;

    @PostMapping("/documents")
    public ResponseEntity<DocumentEntity> createDocument(@RequestParam("file") MultipartFile file,
                                                         @RequestParam("document") String document) throws JsonParseException, Exception {
        System.out.println("Ok .............");
        DocumentEntity documents = new ObjectMapper().readValue(document, DocumentEntity.class);
        String newDocumentFile = storageService.addUserImage(file);
     /* addDocumentfile(file);
      boolean isExit = new File(context.getRealPath("/Documents/")).exists();
      if (!isExit)
      {
      	new File (context.getRealPath("/Documents/")).mkdir();
      	System.out.println("mkdir.............");
      }
      String documentFile = file.getOriginalFilename();
      String newDocumentFile = FilenameUtils.getBaseName(documentFile)+"."+FilenameUtils.getExtension(documentFile);
            
      File serverFile = new File (context.getRealPath("/Documents/"+File.separator+newDocumentFile));
      try
      {
      	System.out.println("Documents");
      	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
      	 
      }catch(Exception e) {
      	e.printStackTrace();
      }
      */

        documents.setDocumentFile(newDocumentFile);
        documentService.saveDocument(documents);

        return ResponseEntity.status(HttpStatus.CREATED).body(documents);
    }


    private void addDocumentfile(MultipartFile file) {
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit) {
            new File(context.getRealPath("/Documents/")).mkdir();
            System.out.println("mk dir Documents.............");
        }
        String documentFile = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(documentFile) + "." + FilenameUtils.getExtension(documentFile);
        File serverFile = new File(context.getRealPath("/Documents/" + File.separator + newFileName));
        try {

            FileUtils.writeByteArrayToFile(serverFile, file.getBytes());

        } catch (Exception e) {
            System.out.println("Failed to Add Document file!!");
        }


    }

    @GetMapping("/document")
    public ResponseEntity<List<DocumentEntity>> getAllDocuments() {
        return ResponseEntity.ok(documentService.getAll());
    }


    @GetMapping("/documentdetail/{id}")
    public Optional<DocumentDTO> documentDetail(@PathVariable Long id) {
        System.out.println(id);
        Optional<DocumentDTO> document = documentService.findDocumentById(id);
        return document;
    }

    @GetMapping(path = "/Document/{id}")
    public ResponseEntity<byte[]> getPhoto(@PathVariable("id") Long id) throws Exception {
        System.out.println("Get all Document ");
        DocumentDTO Document = documentService.findDocumentById(id).get();

        String documentFile = Document.getDocumentFile();
        Optional<byte[]> bytes = Optional.empty();
        if (documentFile != null) {
            bytes = Optional.of(Files.readAllBytes(storageService.buildDocumentFile(documentFile)));
        }
        return  ResponseEntity.of(bytes);
    }


    @GetMapping("/document/{userId}")
    public ResponseEntity<List<DocumentDTO>> getDocumentsByProfesseur(@PathVariable Long userId) {
        List<DocumentDTO> documents = documentService.getDocumentsByUser(userId);
        return ResponseEntity.ok(documents);
    }

    /*@GetMapping("/documents/cours/{courId}")
    public ResponseEntity<List<DocumentDTO>> getDocumentsByCours(@PathVariable Long courId) {
        System.out.println("Liste de documents pour le cours " + courId);
        List<DocumentEntity> documents = documentService.getDocumentsByCoursId(courId);
        List<DocumentDTO>documentss=modelMapperConverter.convertAllToDTO(documents,DocumentDTO.class);
        System.out.println(documentss);
        return ResponseEntity.ok(documentss);
    }*/
    @DeleteMapping("/document/{id}")
    public void deleteDocuments(@PathVariable Long id) {
        documentService.deleteDocument(id);
    }

    @PutMapping("/document/{id}")
    public void update(@PathVariable long id, @RequestParam(value = "file", required = false) MultipartFile file,
                       @RequestParam("document") String document) throws Exception {
        DocumentEntity documents = new ObjectMapper().readValue(document, DocumentEntity.class);
        deleteDocumentFile(documents);
        // System.out.println("hhhhhh" +file);

        if (file != null) {
//            String imgfile = file.getOriginalFilename();
//            String newImgfile = FilenameUtils.getBaseName(imgfile) + "." + FilenameUtils.getExtension(imgfile);
 //            userr.setImgfile(newImgfile);
            // String newImgfile = addUserImage(file);
            String newDocumentfile = storageService.addDocumentFile(file);
            documents.setDocumentFile(newDocumentfile);
        }
        documents.setId(id);
        documentService.update(documents);
    }

    private void deleteDocumentFile(DocumentEntity document) {
        System.out.println(" Delete Document ");
        try {
            File file = storageService.buildDocumentFile(document.getDocumentFile()).toFile();
            System.out.println(document.getDocumentFile());
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
