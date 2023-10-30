package com.elearning.dto;

import com.elearning.entities.MatiereEntity;
import com.elearning.entities.RoleEntity;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDetailDTO extends MyDTO implements Serializable{
	
	
	public UserDetailDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UserDetailDTO(Long id, String email, String password, String firstName, String lastName, String username,
			RoleEntity roles, String addresse, String telephone, String imgfile, String apropos, String ncin,
			String status, List<MatiereEntity> matieres) {
		super();
		Id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.roles = roles;
		this.addresse = addresse;
		this.telephone = telephone;
		this.imgfile = imgfile;
		this.apropos = apropos;
		this.ncin = ncin;
		this.status = status;
		this.matieres = matieres;
	}


	private Long Id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String username;
	private RoleEntity roles;
	private String addresse;
	private String telephone;
	private String imgfile;
	private String apropos;
	private String ncin;
	private String status;

	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "user_matiere", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "matiere_id"))
	List<MatiereEntity> matieres=new ArrayList<>();


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public RoleEntity getRoles() {
		return roles;
	}


	public void setRoles(RoleEntity roles) {
		this.roles = roles;
	}


	public String getAddresse() {
		return addresse;
	}


	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getImgfile() {
		return imgfile;
	}


	public void setImgfile(String imgfile) {
		this.imgfile = imgfile;
	}


	public String getApropos() {
		return apropos;
	}


	public void setApropos(String apropos) {
		this.apropos = apropos;
	}


	public String getNcin() {
		return ncin;
	}


	public void setNcin(String ncin) {
		this.ncin = ncin;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public List<MatiereEntity> getMatieres() {
		return matieres;
	}


	public void setMatieres(List<MatiereEntity> matieres) {
		this.matieres = matieres;
	}

	
	
}
