package com.elearning.dto.etudiant;

import com.elearning.dto.MyDTO;

import java.util.List;

public class ClasseEtudiantDto extends MyDTO {
    private Long id;
    private String nomClasse;
    private String annee;
    private String section;

    private List<CoursEtudiantDto> cours;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<CoursEtudiantDto> getCours() {
        return cours;
    }

    public void setCours(List<CoursEtudiantDto> cours) {
        this.cours = cours;
    }
}
