package com.elearning.dto.theme;

import com.elearning.dto.MyDTO;

public class CoursThemeDto extends MyDTO {

    private Long id;

    private String nomCours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public CoursThemeDto() {
    }
}
