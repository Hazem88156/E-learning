package com.elearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elearning.dto.ChapitreDTO;
import com.elearning.service.ChapitreService;



@RestController
@CrossOrigin()
@RequestMapping("/api")
public class ChapitreController {
	
	@Autowired
	private ChapitreService chapitreService;
	
	@GetMapping("/chapitres")
	public ResponseEntity<List<ChapitreDTO>> getAllChapitres() {
		return ResponseEntity.ok(chapitreService.findAllChapitres());
	}
	/*
	 * method to add user 
	 */
	@PostMapping("/chapitre")
    public ResponseEntity<ChapitreDTO> create(@RequestBody ChapitreDTO chapitreDTO) {
    	chapitreService.addChapitre(chapitreDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(chapitreDTO);
    }

}
