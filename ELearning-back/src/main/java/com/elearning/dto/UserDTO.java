package com.elearning.dto;

import com.elearning.entities.RoleEntity;

import java.io.Serializable;

public class UserDTO extends MyDTO implements Serializable {


    public UserDTO(Long id, String email, String password, String firstName, String lastName, String username,
                   RoleEntity roles, String addresse, String telephone, String imgfile, String apropos, String ncin,
                   String status,  ClasseDTO classesEtudiant) {
        super();
        this.id = id;
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
        this.classesEtudiant = classesEtudiant;
    }

    public UserDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    private Long id;
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

	public ClasseDTO getClassesEtudiant() {
		return classesEtudiant;
	}

	public void setClassesEtudiant(ClasseDTO classesEtudiant) {
		this.classesEtudiant = classesEtudiant;
	}

	private ClasseDTO classesEtudiant;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
