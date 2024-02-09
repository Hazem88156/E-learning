package com.elearning.entities;

import com.elearning.entities.users.EtudiantEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "compte_rendu")
@Inheritance(strategy = InheritanceType.JOINED)
public class CompteREntity extends MyEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;

    @JsonIgnoreProperties("tps")
    @ManyToOne(fetch=FetchType.EAGER)
    private TpEntity tp;

    @JsonIgnoreProperties("etudiants")
    @ManyToOne(fetch=FetchType.EAGER)
    private EtudiantEntity etudiant;
    @Column(length = 10000000)
    private String contenu;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public TpEntity getTp() {
        return tp;
    }

    public void setTp(TpEntity tp) {
        this.tp = tp;
    }

    public EtudiantEntity getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(EtudiantEntity etudiant) {
        this.etudiant = etudiant;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public CompteREntity(Long id, String nom, TpEntity tp, EtudiantEntity etudiant, String contenu) {
        this.id = id;
        this.nom = nom;
        this.tp = tp;
        this.etudiant = etudiant;
        this.contenu = contenu;
    }

    public CompteREntity() {
    }
}
