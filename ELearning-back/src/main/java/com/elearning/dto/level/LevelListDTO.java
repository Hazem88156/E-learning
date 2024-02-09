package com.elearning.dto.level;

import com.elearning.dto.MyDTO;

import java.io.Serializable;

public class LevelListDTO extends MyDTO implements Serializable {
    private Long id;

    private String difficulty;

    private ThemeLevelDTO theme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }



    public LevelListDTO(Long id, String difficulty, String themeName, ThemeLevelDTO theme) {
        this.id = id;
        this.difficulty = difficulty;
        this.theme = theme;
    }

    public LevelListDTO() {
    }

    public ThemeLevelDTO getTheme() {
        return theme;
    }

    public void setTheme(ThemeLevelDTO theme) {
        this.theme = theme;
    }
}
