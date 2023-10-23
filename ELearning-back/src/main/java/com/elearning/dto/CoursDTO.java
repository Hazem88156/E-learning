package com.elearning.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.elearning.entities.ClasseEntity;
import com.elearning.entities.DocumentEntity;
import com.elearning.entities.MatiereEntity;
import com.elearning.entities.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class CoursDTO extends MyDTO implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomCours;

	@ManyToOne
	@JoinColumn(name = "prof_id") // La colonne de jointure dans la table Employee
	private UserEntity user;

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



}
