package com.elearning.dto;

import com.elearning.dto.etudiant.EtudiantDTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class CompteRDTO extends MyDTO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;


    private TpDTO tp;


    private EtudiantDTO etudiant;
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

    public TpDTO getTp() {
        return tp;
    }

    public void setTp(TpDTO tp) {
        this.tp = tp;
    }

    public EtudiantDTO getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(EtudiantDTO etudiant) {
        this.etudiant = etudiant;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public CompteRDTO(Long id, String nom, TpDTO tp, EtudiantDTO etudiant, String contenu) {
        this.id = id;
        this.nom = nom;
        this.tp = tp;
        this.etudiant = etudiant;
        this.contenu = contenu;
    }

    public CompteRDTO() {
    }
}
