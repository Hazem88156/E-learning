package com.elearning.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "classes")
@Inheritance(strategy = InheritanceType.JOINED)
public class ClasseEntity extends MyEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@Column(unique = true, nullable = false)
    private String nomClasse;
	private String section;
	private String annee;
    @OneToMany(cascade = CascadeType.ALL)
    private List<MatiereEntity> matieres = new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public List<MatiereEntity> getMatieres() {
		return matieres;
	}
	public void setMatieres(List<MatiereEntity> matieres) {
		this.matieres = matieres;
	}
	public ClasseEntity() {
		super();
	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}
}

