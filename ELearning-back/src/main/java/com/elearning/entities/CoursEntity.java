package com.elearning.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.elearning.dto.DocumentDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "cours")
@Inheritance(strategy = InheritanceType.JOINED)
public class CoursEntity extends MyEntity implements Serializable{
	
	
	
	
	public CoursEntity(Long id, ClasseEntity classe, MatiereEntity matiere, String nomCours, UserEntity user) {
		super();
		this.id = id;
		this.classe = classe;
		this.matiere = matiere;
		this.nomCours = nomCours;
		this.user = user;
	}
	public CoursEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@JoinColumn(name = "classe_id")
	@JsonIgnoreProperties("cours")
	@ManyToOne(fetch=FetchType.EAGER)
	private ClasseEntity classe;
	@ManyToOne(fetch=FetchType.EAGER)
	private MatiereEntity matiere;
	private String nomCours;
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties("cours")
	@ManyToOne(fetch=FetchType.EAGER)
	private UserEntity user;
	@JsonIgnoreProperties("cours")
	@JsonBackReference(value="document-cours")
	@OneToMany(mappedBy="cour",fetch=FetchType.EAGER)
	private List<DocumentEntity> documents;
	
	@JsonIgnoreProperties("cours")
	@JsonBackReference(value="vedio-cours")
	@OneToMany(mappedBy="cour",fetch=FetchType.LAZY)
	private List<VedioEntity> vedios;
	
	@JsonManagedReference
	@OneToMany(mappedBy="cour",fetch=FetchType.LAZY)
	private List<ExamenEntity> examens;
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
	
	public void setDocuments(List<DocumentEntity> documents) {
		this.documents = documents;
	}
	public List<DocumentEntity> getDocuments() {
		return documents;
	}
	public List<VedioEntity> getVedios() {
		return vedios;
	}
	public void setVedios(List<VedioEntity> vedios) {
		this.vedios = vedios;
	}
	public List<ExamenEntity> getExamens() {
		return examens;
	}
	public void setExamens(List<ExamenEntity> examens) {
		this.examens = examens;
	}
	
}
