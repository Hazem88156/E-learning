package com.elearning.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "tp")
@Inheritance(strategy = InheritanceType.JOINED)
public class TpEntity extends MyEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;
    @JsonIgnoreProperties("documents")
    @ManyToOne(fetch=FetchType.EAGER)
    private DocumentEntity document;
    private String lien;
    private String tpFile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DocumentEntity getDocument() {
        return document;
    }

    public void setDocument(DocumentEntity document) {
        this.document = document;
    }

    public String getTpFile() {
        return tpFile;
    }

    public void setTpFile(String tpFile) {
        this.tpFile = tpFile;
    }

    public TpEntity(Long id, DocumentEntity document, String tpFile,String lien,String nom) {
        this.id = id;
        this.document = document;
        this.tpFile = tpFile;
        this.lien=lien;
        this.nom=nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public TpEntity() {
    }
}
