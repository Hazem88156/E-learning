package com.elearning.dto;

import java.io.Serializable;

public class ReunionDTO extends MyDTO implements Serializable {


    private Long id;
    private String reunionName;

    private CoursDTO cour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReunionName() {
        return reunionName;
    }

    public void setReunionName(String reunionName) {
        this.reunionName = reunionName;
    }

    public CoursDTO getCour() {
        return cour;
    }

    public void setCour(CoursDTO cour) {
        this.cour = cour;
    }

    public ReunionDTO(Long id, String reunionName, CoursDTO cour) {
        this.id = id;
        this.reunionName = reunionName;
        this.cour = cour;
    }

    public ReunionDTO() {
    }
}
