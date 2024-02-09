package com.elearning.controller;

import com.elearning.dto.ThemeDTO;
import com.elearning.dto.theme.ThemeListDto;
import com.elearning.serviceImpl.ThemeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("/api")
public class ThemeController {


    private final ThemeServiceImpl themeServiceImpl;

    public ThemeController(ThemeServiceImpl themeServiceImpl) {
        this.themeServiceImpl = themeServiceImpl;
    }
    @PostMapping("/theme")
    public ResponseEntity<ThemeListDto> create(@RequestBody ThemeDTO themeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(themeServiceImpl.saveTheme(themeDTO));
    }
    @GetMapping("/themes")
    public ResponseEntity<List<ThemeListDto>> getAllThemes() {
        return ResponseEntity.ok(themeServiceImpl.getAll());
    }


    @GetMapping("/themedetail/{id}")
    public Optional<ThemeDTO> themeDetail(@PathVariable Long id) {
        System.out.println(id);
        Optional<ThemeDTO> theme = themeServiceImpl.findThemeById(id);
        return theme;
    }
    @DeleteMapping("/theme/{id}")
    public void deleteThemes(@PathVariable Long id) {
        themeServiceImpl.deleteTheme(id);
    }
}
