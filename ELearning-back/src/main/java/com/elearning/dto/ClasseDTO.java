package com.elearning.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import com.elearning.entities.MatiereEntity;
import com.elearning.entities.UserEntity;

public class ClasseDTO extends MyDTO implements Serializable{
	

	private Long id;
	private String nomClasse;
	private String annee;
	private String section;
	private List<MatiereEntity> matieres =new ArrayList<MatiereEntity>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	public String getAnnee() {
		return annee;
	}

	public void setAnnee(String annee) {
		this.annee = annee;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public List<MatiereEntity> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<MatiereEntity> matieres) {
		this.matieres = matieres;
	}
}
