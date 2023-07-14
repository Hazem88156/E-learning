package com.elearning.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "classes")
@Inheritance(strategy = InheritanceType.JOINED)
public class ClasseEntity extends MyEntity implements Serializable{
	
	public ClasseEntity(Long id, String nomClasse, List<UserEntity> users, List<UserEntity> users1,
			List<MatiereEntity> matieres) {
		super();
		this.id = id;
		this.nomClasse = nomClasse;
		this.users = users;
		this.matieres = matieres;
	}
	public ClasseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomClasse;
    @OneToMany(mappedBy = "classe")
	private List<CoursEntity> cours;
	@JsonIgnore
	@ManyToMany(cascade=CascadeType.DETACH)
	@JoinTable(name = "class_user", joinColumns = @JoinColumn(name = "class_id"),
	inverseJoinColumns = @JoinColumn(name = "user_id"))
	List<UserEntity> users=new ArrayList<>();
	
	@ManyToMany(cascade=CascadeType.DETACH ,fetch = FetchType.LAZY)
	List<MatiereEntity> matieres=new ArrayList<MatiereEntity>();
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
	public List<UserEntity> getUsers() {
		return users;
	}
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	public List<MatiereEntity> getMatieres() {
		return matieres;
	}
	public void setMatieres(List<MatiereEntity> matieres) {
		this.matieres = matieres;
	}
	public List<CoursEntity> getCours() {
		return cours;
	}
	public void setCours(List<CoursEntity> cours) {
		this.cours = cours;
	}
	
	

}
