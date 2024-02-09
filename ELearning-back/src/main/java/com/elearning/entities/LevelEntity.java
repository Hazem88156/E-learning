package com.elearning.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "levels")
@Inheritance(strategy = InheritanceType.JOINED)
public class LevelEntity extends MyEntity {


    public LevelEntity(Long id, String difficulty, List<QuestionEntity> questions, ThemeEntity theme) {
        this.id = id;
        this.difficulty = difficulty;
        this.questions = questions;
        this.theme = theme;
    }
    public LevelEntity() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnoreProperties("level")
    @ManyToOne(fetch=FetchType.EAGER)
    private LevelEntity level;
    private String difficulty;

    @JsonIgnoreProperties("level")
    @JsonBackReference(value="level-question")
    @OneToMany(mappedBy = "level", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private List<QuestionEntity> questions;
    public void addQuestion(QuestionEntity question) {
        if (getQuestions()==null) {
            this.questions = new ArrayList<>();
        }
        getQuestions().add(question);
        question.setLevel(this);
    }
    @ManyToOne
    private ThemeEntity theme;
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

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }

    public ThemeEntity getTheme() {
        return theme;
    }

    public void setTheme(ThemeEntity theme) {
        this.theme = theme;
    }

    public LevelEntity getLevel() {
        return level;
    }

    public void setLevel(LevelEntity level) {
        this.level = level;
    }
}
