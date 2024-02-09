package com.elearning.dto.etudiant;

import com.elearning.entities.ClasseEntity;


public class UpdateEtudiantDTO extends CreateEtudiantDTO {
    private ClasseEntity classesEtudiant;

    private String status;

    public ClasseEntity getClassesEtudiant() {
        return classesEtudiant;
    }

    public void setClassesEtudiant(ClasseEntity classesEtudiant) {
        this.classesEtudiant = classesEtudiant;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
