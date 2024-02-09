package com.elearning.dto.question;

import com.elearning.dto.MyDTO;

import java.io.Serializable;

public class LevelQuestionDTO extends MyDTO implements Serializable {

    private Long id;

    private String difficulty;

    private String themeName;

    public LevelQuestionDTO(Long id, String difficulty, String themeName) {
        this.id = id;
        this.difficulty = difficulty;
        this.themeName = themeName;
    }

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

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public LevelQuestionDTO() {
    }
}
