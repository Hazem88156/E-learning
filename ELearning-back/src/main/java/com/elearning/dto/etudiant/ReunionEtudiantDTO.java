package com.elearning.dto.etudiant;

import com.elearning.dto.MyDTO;

public class ReunionEtudiantDTO extends MyDTO {

    private Long id;
    private String reunionName;

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

    public ReunionEtudiantDTO(Long id, String reunionName) {
        this.id = id;
        this.reunionName = reunionName;
    }

    public ReunionEtudiantDTO() {
    }
}
