package com.elearning.dto;

import java.io.Serializable;



public class MatiereDTO extends MyDTO implements Serializable{
	public MatiereDTO(Long id, String nomMatiere) {
		super();
		this.id = id;
		this.nomMatiere = nomMatiere;

	}
	
	public MatiereDTO() {
		super();
	}
	private Long id;
	private String nomMatiere;
	private Double coeif;
	private Double nbHeure;

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
