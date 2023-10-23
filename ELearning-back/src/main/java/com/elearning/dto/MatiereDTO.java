package com.elearning.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.elearning.entities.CoursEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;



public class MatiereDTO extends MyDTO implements Serializable{
	public MatiereDTO(Long id, String nomMatiere) {
		super();
		this.id = id;
		this.nomMatiere = nomMatiere;

	}
	
	public MatiereDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
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

	public String getCoeif() {
		return coeif;
	}

	public void setCoeif(String coeif) {
		this.coeif = coeif;
	}

	public String getNbHeure() {
		return nbHeure;
	}

	public void setNbHeure(String nbHeure) {
		this.nbHeure = nbHeure;
	}

	public List<CoursEntity> getCours() {
		return cours;
	}

	public void setCours(List<CoursEntity> cours) {
		this.cours = cours;
	}
}
