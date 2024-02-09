package com.elearning.entities;

import com.elearning.entities.users.ProfEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "cours")
@Inheritance(strategy = InheritanceType.JOINED)
public class CoursEntity extends MyEntity implements Serializable{

	public CoursEntity() {
	}

	public CoursEntity(Long id, String nomCours, Date heureDebut, Date heureFin, ProfEntity user, ClasseEntity classe, MatiereEntity matiere) {
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
	private ProfEntity user;
	@ManyToOne
	@JoinColumn(name = "classe_id") // La colonne de jointure dans la table Employee
	private ClasseEntity classe;
	@ManyToOne
	@JoinColumn(name = "matiere_id") // La colonne de jointure dans la table Employee
	private MatiereEntity matiere;

	@JsonIgnoreProperties("cours")
	@JsonBackReference(value="document-cours")
	@OneToMany(mappedBy="cour",fetch=FetchType.LAZY)
	private List<DocumentEntity> documents;

	@JsonIgnoreProperties("cours")
	@JsonBackReference(value="reunion-cours")
	@OneToMany(mappedBy="cour",fetch=FetchType.LAZY)
	private List<ReunionEntity> reunions;

	@JsonIgnoreProperties("cours")
	@JsonBackReference(value="theme-cours")
	@OneToMany(mappedBy="cour",fetch=FetchType.LAZY)
	private List<ThemeEntity> themes;

	@OneToMany(mappedBy="cour",fetch=FetchType.LAZY)
	private List<VedioEntity> videos = new ArrayList<>();

	private String coursFile;


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

	public ProfEntity getUser() {
		return user;
	}

	public void setUser(ProfEntity user) {
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

	public List<DocumentEntity> getDocuments() {
		return documents;
	}

	public void setDocuments(List<DocumentEntity> documents) {
		this.documents = documents;
	}

	public List<VedioEntity> getVideos() {
		return videos;
	}

	public void setVideos(List<VedioEntity> videos) {
		this.videos = videos;
	}

	public List<ThemeEntity> getThemes() {
		return themes;
	}

	public void setThemes(List<ThemeEntity> themes) {
		this.themes = themes;
	}

	public List<ReunionEntity> getReunions() {
		return reunions;
	}

	public void setReunions(List<ReunionEntity> reunions) {
		this.reunions = reunions;
	}

	public String getCoursFile() {
		return coursFile;
	}

	public void setCoursFile(String coursFile) {
		this.coursFile = coursFile;
	}
}
