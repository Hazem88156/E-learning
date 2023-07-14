package com.elearning.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



public class MatiereDTO extends MyDTO implements Serializable{
	public MatiereDTO(Long id, String nomMatiere, List<UserDTO> users) {
		super();
		this.id = id;
		this.nomMatiere = nomMatiere;
		this.users = users;
	}
	
	public MatiereDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nomMatiere;
	@JsonIgnore
	@ManyToMany(mappedBy="matieres",cascade=CascadeType.ALL)
	List<UserDTO> users=new ArrayList<UserDTO>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomMatiere() {
		return nomMatiere;
	}
	public void setNomMatiere(String nomMatiere) {
		this.nomMatiere = nomMatiere;
	}
	public List<UserDTO> getUsers() {
		return users;
	}
	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}
	
}
