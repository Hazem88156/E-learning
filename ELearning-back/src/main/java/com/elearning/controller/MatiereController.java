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
import com.elearning.dto.MatiereDTO;
import com.elearning.service.MatiereService;

@CrossOrigin(origins = "**")
@RestController
@RequestMapping("/api")
public class MatiereController {
	@Autowired
	private MatiereService matiereService;
	@GetMapping("/matieres")
	public ResponseEntity<List<MatiereDTO>> getAllMatieres() {
		return ResponseEntity.ok(matiereService.findAllMatieres());
	}
	/*
	 * method to add user 
	 */
	@PostMapping("/matiere")
    public ResponseEntity<MatiereDTO> create(@RequestBody MatiereDTO matiereDTO) {
    	matiereService.addMatiere(matiereDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(matiereDTO);
    }
}
