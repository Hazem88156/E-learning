package com.elearning.dto;

import java.io.Serializable;
import java.util.List;

public class ThemeDTO extends MyDTO implements Serializable {
    public ThemeDTO() {
    }

    public ThemeDTO(Long id, String name, List<LevelDTO> levels) {
        this.id = id;
        this.name = name;
        this.levels = levels;
    }

    private Long id;

    private String name;

    private List<LevelDTO> levels;

    private CoursDTO cour;

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

    public List<LevelDTO> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelDTO> levels) {
        this.levels = levels;
    }

    public CoursDTO getCour() {
        return cour;
    }

    public void setCour(CoursDTO cour) {
        this.cour = cour;
    }
}
