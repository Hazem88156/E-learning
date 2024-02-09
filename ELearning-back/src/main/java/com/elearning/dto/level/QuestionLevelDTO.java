package com.elearning.dto.level;

import com.elearning.dto.MyDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class QuestionLevelDTO extends MyDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String question;

    private String response1;

    private String response2;

    private String response3;



    private String correct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResponse1() {
        return response1;
    }

    public void setResponse1(String response1) {
        this.response1 = response1;
    }

    public String getResponse2() {
        return response2;
    }

    public void setResponse2(String response2) {
        this.response2 = response2;
    }

    public String getResponse3() {
        return response3;
    }

    public void setResponse3(String response3) {
        this.response3 = response3;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public QuestionLevelDTO(Long id, String question, String response1, String response2, String response3, String correct) {
        this.id = id;
        this.question = question;
        this.response1 = response1;
        this.response2 = response2;
        this.response3 = response3;
        this.correct = correct;
    }

    public QuestionLevelDTO() {
    }
}
