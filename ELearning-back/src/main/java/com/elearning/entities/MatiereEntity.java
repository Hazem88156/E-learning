package com.elearning.entities;

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
    private String coeif;
    private String nbHeure;
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

    public String getNbHeure() {
        return nbHeure;
    }

    public void setNbHeure(String nbHeure) {
        this.nbHeure = nbHeure;
    }

    public String getCoeif() {
        return coeif;
    }

    public void setCoeif(String coeif) {
        this.coeif = coeif;
    }

}
