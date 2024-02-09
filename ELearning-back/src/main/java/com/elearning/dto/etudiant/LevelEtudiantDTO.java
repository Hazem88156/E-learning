package com.elearning.dto.etudiant;

import com.elearning.dto.MyDTO;

import java.util.List;

public class LevelEtudiantDTO extends MyDTO {
    private Long id;

    private String difficulty;

    private List<QuestionEtudiantDTO> questions;

    public LevelEtudiantDTO(){}

    public LevelEtudiantDTO(Long id, String difficulty) {
        this.id = id;
        this.difficulty = difficulty;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<QuestionEtudiantDTO> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEtudiantDTO> questions) {
        this.questions = questions;
    }
}
