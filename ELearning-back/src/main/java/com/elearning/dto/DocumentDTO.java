package com.elearning.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.elearning.entities.ClasseEntity;
import com.elearning.entities.CoursEntity;
import com.elearning.entities.MatiereEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;



public class DocumentDTO extends MyDTO implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String documentName;
	private String documentFile;
    
	@ManyToOne(fetch=FetchType.LAZY)
	private CoursEntity cour;
	@ManyToOne(cascade =CascadeType.ALL)
	private ClasseEntity classe;
	@ManyToOne(cascade =CascadeType.ALL)
	private MatiereEntity matiere;
	public Long getId() {
		return id;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDocumentFile() {
		return documentFile;
	}
	public void setDocumentFile(String documentFile) {
		this.documentFile = documentFile;
	}
	public ClasseEntity getClasse() {
		return classe;
	}
	public void setClasse(ClasseEntity classe) {
		this.classe = classe;
	}
	public MatiereEntity getMatiere() {
		return matiere;
	}
	public void setMatiere(MatiereEntity matiere) {
		this.matiere = matiere;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public CoursEntity getCour() {
		return cour;
	}
	public void setCour(CoursEntity cour) {
		this.cour = cour;
	}
	
}
