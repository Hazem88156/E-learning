package com.elearning.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


public class CoursDTO extends MyDTO implements Serializable{

	private Long id;
	private String nomCours;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date heureDebut;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date heureFin;

	private UserDTO user;
	private ClasseDTO classe;
	private MatiereDTO matiere;

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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public ClasseDTO getClasse() {
		return classe;
	}

	public void setClasse(ClasseDTO classe) {
 		this.classe = classe;
	}

	public MatiereDTO getMatiere() {
		return matiere;
	}

	public void setMatiere(MatiereDTO matiere) {
		this.matiere = matiere;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}