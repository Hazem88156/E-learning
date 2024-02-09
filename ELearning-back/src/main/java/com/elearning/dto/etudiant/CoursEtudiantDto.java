package com.elearning.dto.etudiant;

import com.elearning.dto.MyDTO;

import java.util.Date;
import java.util.List;

public class CoursEtudiantDto  extends MyDTO {
    private Long id;

    private String nomCours;
    private Date date;
    private Date heureDebut;
    private Date heureFin;

    private ProfEtudiantDTO user;

    private List<DocumentEtudiantDTO> documents;
    private List<VideoEtudiantDTO> videos;

    private List<ReunionEtudiantDTO> reunions;

    private List<ThemeEtudiantDTO> themes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomCours() {
        return nomCours;
    }

    public void setNomCours(String nomCours) {
        this.nomCours = nomCours;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    public ProfEtudiantDTO getUser() {
        return user;
    }

    public void setUser(ProfEtudiantDTO user) {
        this.user = user;
    }

    public List<DocumentEtudiantDTO> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentEtudiantDTO> documents) {
        this.documents = documents;
    }

    public List<VideoEtudiantDTO> getVideos() {
        return videos;
    }

    public void setVideos(List<VideoEtudiantDTO> videos) {
        this.videos = videos;
    }

    public List<ReunionEtudiantDTO> getReunions() {
        return reunions;
    }

    public void setReunions(List<ReunionEtudiantDTO> reunions) {
        this.reunions = reunions;
    }

    public List<ThemeEtudiantDTO> getThemes() {
        return themes;
    }

    public void setThemes(List<ThemeEtudiantDTO> themes) {
        this.themes = themes;
    }
}
