package com.elearning.entities;

import java.io.Serializable;
import java.util.Date;
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

	public CoursEntity(Long id ,String nomCours) {
		super();
		this.id = id;
		this.nomCours = nomCours;

	}
	public CoursEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomCours;


	@ManyToOne
	@JoinColumn(name = "prof_id") // La colonne de jointure dans la table Employee
	private UserEntity user;
	@ManyToOne
	@JoinColumn(name = "classe_id") // La colonne de jointure dans la table Employee
	private ClasseEntity classe;
	@ManyToOne
	@JoinColumn(name = "matiere_id") // La colonne de jointure dans la table Employee
	private MatiereEntity matiere;
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
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
}
