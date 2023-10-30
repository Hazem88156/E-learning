package com.elearning.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "cours")
@Inheritance(strategy = InheritanceType.JOINED)
public class CoursEntity extends MyEntity implements Serializable{

	public CoursEntity() {
	}

	public CoursEntity(Long id, String nomCours, Date heureDebut, Date heureFin, UserEntity user, ClasseEntity classe, MatiereEntity matiere) {
		this.id = id;
		this.nomCours = nomCours;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.user = user;
		this.classe = classe;
		this.matiere = matiere;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String nomCours;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date date;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date heureDebut;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date heureFin;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
