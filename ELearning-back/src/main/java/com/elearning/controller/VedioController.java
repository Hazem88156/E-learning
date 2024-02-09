package com.elearning.controller;

import com.elearning.dto.VideoDTO;
import com.elearning.entities.VedioEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.service.StorageService;
import com.elearning.serviceImpl.VedioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
public class VedioController {
	@Autowired
	private VedioService vedioService;
	@Autowired
	private ModelMapperConverter modelMapperConverter;
	@Autowired  ServletContext context;
	@Autowired
	private StorageService storageService;
	@PostMapping("/vedios")
	 public ResponseEntity<VedioEntity> createVedio (
			 @RequestParam("file") MultipartFile file,
			 @RequestParam("vedio") String vedio
	) throws JsonParseException , Exception {
		 System.out.println("Ok .............");
     VedioEntity vedios = new ObjectMapper().readValue(vedio, VedioEntity.class);
	 String newVedioFile = storageService.addVideoFile(file);
     /*addDocumentfile(file);
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
     }*/

     
     vedios.setVedioFile(newVedioFile);
     vedioService.saveVedio(vedios);
    
     return ResponseEntity.status(HttpStatus.CREATED).body(vedios);
	 }
	
	
	 private void addVediofile(MultipartFile file)
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
public Optional<VideoDTO> vedioDetail(@PathVariable Long id) {
	  System.out.println(id);
	  Optional<VideoDTO> vedio = vedioService.vediofindById(id);
      return vedio;
  }
@GetMapping(path="/Vedio/{id}")
public ResponseEntity<byte[]> getVedio(@PathVariable("id") Long id) throws Exception{
	 System.out.println("Get all Vedio ");
	 VideoDTO Vedio   =vedioService.vediofindById(id).get();
	 byte[] bytes = Files.readAllBytes(storageService.buildVideoFile(Vedio.getVedioFile()));
	 return ResponseEntity
			 .status(HttpStatus.OK)
			 .contentType(MediaType.APPLICATION_OCTET_STREAM)
			 .body(bytes);
}
@GetMapping("/vedio/{userId}")
public ResponseEntity<List<VideoDTO>> getVediosByProfesseur(@PathVariable Long userId) {
    List<VideoDTO> vedios = vedioService.getVideoByUser(userId);
    return ResponseEntity.ok(vedios);
}
 
/*@GetMapping("/vedios/cours/{courId}")
 public ResponseEntity<List<VideoDTO>> getVediosByCours(@PathVariable Long courId) {
	System.out.println("Liste de veios pour le cours " + courId);
    List<VedioEntity> vedios = vedioService.getVediosByCoursId(courId);
    List<VideoDTO> vedio=modelMapperConverter.convertAllToDTO(vedios,VideoDTO.class);
    System.out.println(vedio);
    return ResponseEntity.ok(vedio);
 }*/

	@PutMapping("/video/{id}")
	public void update(@PathVariable long id, @RequestParam(value = "file", required = false) MultipartFile file,
					   @RequestParam("video") String video) throws Exception {
		VedioEntity videos = new ObjectMapper().readValue(video, VedioEntity.class);
		deleteVideoFile(videos);
		// System.out.println("hhhhhh" +file);

		if (file != null) {
//            String imgfile = file.getOriginalFilename();
//            String newImgfile = FilenameUtils.getBaseName(imgfile) + "." + FilenameUtils.getExtension(imgfile);
//            userr.setImgfile(newImgfile);
			// String newImgfile = addUserImage(file);
			String newVideofile = storageService.addVideoFile(file);
			videos.setVedioFile(newVideofile);
		}
		videos.setId(id);
		vedioService.update(videos);
	}
	private void deleteVideoFile(VedioEntity video) {
		System.out.println(" Delete Video ");
		try {
			File file = storageService.buildUserImagePath(video.getVedioFile()).toFile();
			System.out.println(video.getVedioFile());
			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete operation is failed.");
			}
		} catch (Exception e) {
			System.out.println("Failed to Delete document !!");
		}
	}
	@DeleteMapping("/video/{id}")
	public void deleteVideos(@PathVariable Long id) {
		vedioService.deleteVedio(id);
	}
}
