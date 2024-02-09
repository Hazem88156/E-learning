package com.elearning.controller;

import com.elearning.dto.LevelDTO;
import com.elearning.dto.level.LevelListDTO;
import com.elearning.service.LevelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api")
public class LevelController {

    private final LevelService levelService;

    public LevelController(LevelService levelService) {
        this.levelService = levelService;
    }

    @PostMapping("/addLevel/{idTheme}")
    public LevelListDTO addLevel(@RequestBody LevelDTO level, @PathVariable("idTheme") Long idTheme) {
        return levelService.addLevel(level, idTheme);
    }
    @GetMapping("/getLevels/{idTheme}")
    public ResponseEntity<List<LevelListDTO>> getLevels(@PathVariable("idTheme") Long idTheme) {
        return ResponseEntity.of(levelService.getLevels(idTheme));
    }
    @GetMapping("/getLevel/{idTheme}")
    public LevelListDTO getLevel(@PathVariable("idTheme") Long idTheme) {
        return levelService.getLevel(idTheme);
    }

    @DeleteMapping("/level/{id}")
    public void deleteLevel(@PathVariable Long id) {
        levelService.deleteLevel(id);
    }
}
