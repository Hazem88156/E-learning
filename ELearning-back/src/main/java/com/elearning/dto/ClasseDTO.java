package com.elearning.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import com.elearning.entities.MatiereEntity;
import com.elearning.entities.UserEntity;

public class ClasseDTO extends MyDTO implements Serializable{
	
    public ClasseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ClasseDTO(Long id, String nomClasse, List<UserEntity> users, List<MatiereEntity> matieres) {
		super();
		this.id = id;
		this.nomClasse = nomClasse;
		this.users = users;
		this.matieres = matieres;
	}
	private Long id;
	private String nomClasse;
    
	@ManyToMany(cascade=CascadeType.DETACH)
	private List<UserEntity> users =new ArrayList<UserEntity>();
    
	@ManyToMany(cascade=CascadeType.DETACH)
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
	
}
