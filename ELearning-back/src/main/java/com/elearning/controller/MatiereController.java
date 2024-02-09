package com.elearning.controller;

import com.elearning.dto.MatiereDTO;
import com.elearning.entities.MatiereEntity;
import com.elearning.service.MatiereService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("/api/matiere")
public class MatiereController {
	private final MatiereService matiereService;

	public MatiereController(MatiereService matiereService) {
		this.matiereService = matiereService;
	}

	@GetMapping()
	public ResponseEntity<List<MatiereDTO>> getAllMatieres() {
		return ResponseEntity.ok(matiereService.findAllMatieres());
	}

	@PostMapping()
    public ResponseEntity<MatiereDTO> create(@RequestBody MatiereDTO matiereDTO) {
		return ResponseEntity.status(HttpStatus.CREATED).body(matiereService.saveMatiere(matiereDTO));
    }

	@PutMapping("{id}")
	public ResponseEntity<MatiereDTO> update(@RequestBody MatiereDTO matiereDTO, @PathVariable("id") Long id) {
		return ResponseEntity.of(matiereService.updateMatiere(id, matiereDTO));
	}
	

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		matiereService.deleteMatiere(id);
	}

	@GetMapping("{id}")
	public ResponseEntity<MatiereEntity> matiereDetail(@PathVariable Long id) {
		System.out.println(id);
		Optional<MatiereEntity> matiere = matiereService.findById(id);
		return ResponseEntity.of(matiere);
	}
}
