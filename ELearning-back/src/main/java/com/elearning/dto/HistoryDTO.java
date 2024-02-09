package com.elearning.dto;

import java.io.Serializable;

public class HistoryDTO extends MyDTO implements Serializable {
    public HistoryDTO() {
    }

    public HistoryDTO(Long id, String username, String themeName, String levelName, int total, int score) {
        this.id = id;
        this.username = username;
        this.themeName = themeName;
        this.levelName = levelName;
        this.total = total;
        this.score = score;
    }

    private Long id;

    private String username;

    private String themeName;

    private String levelName;

    private int total;

    private int score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
