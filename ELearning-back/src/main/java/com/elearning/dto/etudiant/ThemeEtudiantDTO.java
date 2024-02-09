package com.elearning.dto.etudiant;

import com.elearning.dto.MyDTO;

import java.util.ArrayList;
import java.util.List;

public class ThemeEtudiantDTO extends MyDTO {

    private Long id;

    private String name;

    private List<LevelEtudiantDTO> levels = new ArrayList<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LevelEtudiantDTO> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelEtudiantDTO> levels) {
        this.levels = levels;
    }
}
