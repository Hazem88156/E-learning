package com.elearning.controller;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.elearning.dto.DocumentDTO;
import com.elearning.entities.DocumentEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.serviceImpl.DocumentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin()
@RequestMapping("/api")
public class DocumentController {
	@Autowired
	private ModelMapperConverter modelMapperConverter;
	@Autowired
	private DocumentServiceImpl documentService;
	@Autowired  ServletContext context;
	
	@PostMapping("/documents")
	 public ResponseEntity<DocumentEntity> createDocument (@RequestParam("file") MultipartFile file,
			 @RequestParam("document") String document) throws JsonParseException , Exception
	 {
		 System.out.println("Ok .............");
      DocumentEntity documents = new ObjectMapper().readValue(document, DocumentEntity.class);
      addDocumentfile(file);
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

      
      documents.setDocumentFile(newDocumentFile);
      documentService.saveDocument(documents);
     
      return ResponseEntity.status(HttpStatus.CREATED).body(documents);
	 }
	
	
	 private void addDocumentfile(MultipartFile file)
	    {
	    	boolean isExit = new File(context.getRealPath("/Images/")).exists();
		    if (!isExit)
		    {
		    	new File (context.getRealPath("/Documents/")).mkdir();
		    	System.out.println("mk dir Documents.............");
		    }
		    String documentFile = file.getOriginalFilename();
		    String newFileName = FilenameUtils.getBaseName(documentFile)+"."+FilenameUtils.getExtension(documentFile);
		    File serverFile = new File (context.getRealPath("/Documents/"+File.separator+newFileName));
		    try
		    {
		    
		    	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
		    	 
		    }catch(Exception e) {
		    	 System.out.println("Failed to Add Document file!!");
		    }
		    
	    	
	    }
	 @GetMapping("/document")
		public ResponseEntity<List<DocumentEntity>> getAllDocuments() {
			return ResponseEntity.ok(documentService.getAll());
		}
	


@GetMapping("documentdetail/{id}")
public Optional<DocumentEntity> documentDetail(@PathVariable Long id) {
	  System.out.println(id);
	  Optional<DocumentEntity> document = documentService.documentfindById(id);
       return document;
   }
@GetMapping(path="/Document/{id}")
public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
	 System.out.println("Get all Document ");
	 DocumentEntity Document   =documentService.documentfindById(id).get();
	 return Files.readAllBytes(Paths.get(context.getRealPath("/Documents/")+Document.getDocumentFile()));
}
@GetMapping("/document/{userId}")
public ResponseEntity<List<DocumentEntity>> getDocumentsByProfesseur(@PathVariable Long userId) {
    List<DocumentEntity> documents = documentService.getDocumentsByUser(userId);
   
    return ResponseEntity.ok(documents);
}
@GetMapping("/documents/cours/{courId}")
public ResponseEntity<List<DocumentDTO>> getDocumentsByCours(@PathVariable Long courId) {
	System.out.println("Liste de documents pour le cours " + courId);
    List<DocumentEntity> documents = documentService.getDocumentsByCoursId(courId);
    List<DocumentDTO>documentss=modelMapperConverter.convertAllToDTO(documents,DocumentDTO.class);
    System.out.println(documentss);
    return ResponseEntity.ok(documentss);
}

}
