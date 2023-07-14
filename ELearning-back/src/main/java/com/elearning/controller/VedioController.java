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
import org.springframework.http.MediaType;
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
import com.elearning.dto.VideoDTO;
import com.elearning.entities.DocumentEntity;
import com.elearning.entities.VedioEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.serviceImpl.VedioService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin()
@RequestMapping("/api")
public class VedioController {
	@Autowired
	private VedioService vedioService;
	@Autowired
	private ModelMapperConverter modelMapperConverter;
	@Autowired  ServletContext context;
	@PostMapping("/vedios")
	 public ResponseEntity<VedioEntity> createVedio (@RequestParam("file") MultipartFile file,
			 @RequestParam("vedio") String vedio) throws JsonParseException , Exception
	 {
		 System.out.println("Ok .............");
     VedioEntity vedios = new ObjectMapper().readValue(vedio, VedioEntity.class);
     addDocumentfile(file);
     boolean isExit = new File(context.getRealPath("/Vedios/")).exists();
     if (!isExit)
     {
     	new File (context.getRealPath("/Vedios/")).mkdir();
     	System.out.println("mkdir.............");
     }
     String vedioFile = file.getOriginalFilename();
     String newVedioFile = FilenameUtils.getBaseName(vedioFile)+"."+FilenameUtils.getExtension(vedioFile);
           
     File serverFile = new File (context.getRealPath("/Vedios/"+File.separator+newVedioFile));
     try
     {
     	System.out.println("Vedios");
     	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
     	 
     }catch(Exception e) {
     	e.printStackTrace();
     }

     
     vedios.setVedioFile(newVedioFile);
     vedioService.saveVedio(vedios);
    
     return ResponseEntity.status(HttpStatus.CREATED).body(vedios);
	 }
	
	
	 private void addDocumentfile(MultipartFile file)
	    {
	    	boolean isExit = new File(context.getRealPath("/Vedios/")).exists();
		    if (!isExit)
		    {
		    	new File (context.getRealPath("/Vedios/")).mkdir();
		    	System.out.println("mk dir Documents.............");
		    }
		    String vedioFile = file.getOriginalFilename();
		    String newVedioName = FilenameUtils.getBaseName(vedioFile)+"."+FilenameUtils.getExtension(vedioFile);
		    File serverFile = new File (context.getRealPath("/Vedios/"+File.separator+newVedioName));
		    try
		    {
		    
		    	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
		    	 
		    }catch(Exception e) {
		    	 System.out.println("Failed to Add Document file!!");
		    }
		    
	    	
	    }
	 @GetMapping("/vedio")
		public ResponseEntity<List<VedioEntity>> getAllVedios() {
			return ResponseEntity.ok(vedioService.getAll());
		}
	


@GetMapping("vediodetail/{id}")
public Optional<VedioEntity> vedioDetail(@PathVariable Long id) {
	  System.out.println(id);
	  Optional<VedioEntity> vedio = vedioService.vediofindById(id);
      return vedio;
  }
@GetMapping(path="/Vedio/{id}")
public ResponseEntity<byte[]> getVedio(@PathVariable("id") Long id) throws Exception{
	 System.out.println("Get all Vedio ");
	 VedioEntity Vedio   =vedioService.vediofindById(id).get();
	 byte[] bytes = Files.readAllBytes(Paths.get(context.getRealPath("/Vedios/")+Vedio.getVedioFile()));
	 return ResponseEntity
			 .status(HttpStatus.OK)
			 .contentType(MediaType.APPLICATION_OCTET_STREAM)
			 .body(bytes);
}
@GetMapping("/vedio/{userId}")
public ResponseEntity<List<VedioEntity>> getVediosByProfesseur(@PathVariable Long userId) {
    List<VedioEntity> vedios = vedioService.getVediosByUser(userId);
    return ResponseEntity.ok(vedios);
}
 
@GetMapping("/vedios/cours/{courId}")
 public ResponseEntity<List<VideoDTO>> getVediosByCours(@PathVariable Long courId) {
	System.out.println("Liste de veios pour le cours " + courId);
    List<VedioEntity> vedios = vedioService.getVediosByCoursId(courId);
    List<VideoDTO> vedio=modelMapperConverter.convertAllToDTO(vedios,VideoDTO.class);
    System.out.println(vedio);
    return ResponseEntity.ok(vedio);
 }


}
