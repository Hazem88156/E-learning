package com.elearning.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.elearning.entities.ClasseEntity;
import com.elearning.entities.DocumentEntity;
import com.elearning.entities.MatiereEntity;
import com.elearning.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CoursDTO extends MyDTO implements Serializable{
	public CoursDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CoursDTO(Long id, ClasseEntity classe, MatiereEntity matiere, String nomCours, UserEntity user,
			List<DocumentEntity> documents) {
		super();
		this.id = id;
		this.classe = classe;
		this.matiere = matiere;
		this.nomCours = nomCours;
		this.user = user;
		this.documents = documents;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch=FetchType.EAGER)
	private ClasseEntity classe;
	@ManyToOne(fetch=FetchType.EAGER)
	private MatiereEntity matiere;
	private String nomCours;
	@ManyToOne(fetch=FetchType.EAGER)
	private UserEntity user;
	@JsonIgnore
	@OneToMany(mappedBy="cour",fetch=FetchType.EAGER)
	private List<DocumentEntity> documents;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getNomCours() {
		return nomCours;
	}
	public void setNomCours(String nomCours) {
		this.nomCours = nomCours;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	public List<DocumentEntity> getDocuments() {
		return documents;
	}
	public void setDocuments(List<DocumentEntity> documents) {
		this.documents = documents;
	}

}
