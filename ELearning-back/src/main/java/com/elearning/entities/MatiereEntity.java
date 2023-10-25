package com.elearning.entities;

import com.elearning.dto.ClasseDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "matiere")
@Inheritance(strategy = InheritanceType.JOINED)
public class MatiereEntity extends MyEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String nomMatiere;
    private Double coeif;
    private Double nbHeure;


    @OneToMany(cascade = CascadeType.ALL)
    private List<CoursEntity> cours = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public List<CoursEntity> getCours() {
        return cours;
    }

    public void setCours(List<CoursEntity> cours) {
        this.cours = cours;
    }

    public Double getCoeif() {
        return coeif;
    }

    public void setCoeif(Double coeif) {
        this.coeif = coeif;
    }

    public Double getNbHeure() {
        return nbHeure;
    }

    public void setNbHeure(Double nbHeure) {
        this.nbHeure = nbHeure;
    }


}
