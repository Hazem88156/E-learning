package com.elearning.dto;

import com.elearning.entities.Role;

import java.io.Serializable;

public class UserDetailDTO extends MyDTO implements Serializable{
	
	
	public UserDetailDTO() {
		super();
	}


	public UserDetailDTO(Long id, String email, String password, String firstName, String lastName, String username,
                         Role roles, String addresse, String telephone, String imgfile, String apropos, String ncin,
                         String status) {
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
	}


	private Long Id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String username;
	private Role roles;
	private String addresse;
	private String telephone;
	private String imgfile;
	private String apropos;
	private String ncin;
	private String status;


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


	public Role getRoles() {
		return roles;
	}


	public void setRoles(Role roles) {
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

	
	
}
