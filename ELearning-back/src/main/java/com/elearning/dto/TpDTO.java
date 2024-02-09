package com.elearning.dto;


import java.io.Serializable;

public class TpDTO extends MyDTO implements Serializable {
    private Long id;
    private String tpFile;

    private String nom;

    private String lien;

    private DocumentDTO document;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTpFile() {
        return tpFile;
    }

    public void setTpFile(String tpFile) {
        this.tpFile = tpFile;
    }

    public DocumentDTO getDocument() {
        return document;
    }

    public void setDocument(DocumentDTO document) {
        this.document = document;
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

    public TpDTO(Long id, DocumentDTO document, String tpFile, String lien, String nom) {
        this.id = id;
        this.document = document;
        this.tpFile = tpFile;
        this.lien = lien;
        this.nom = nom;

    }

    public TpDTO() {
    }
}
