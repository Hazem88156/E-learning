package com.elearning.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class UserEntity extends MyEntity implements Serializable {

	

	
	public UserEntity(Long id, String email, String username, String password, String firstName, String lastName,
			String addresse, String telephone, String imgfile, String apropos, String ncin, String status,
			ClasseEntity classesEtudiant, List<CoursEntity> cours, List<MatiereEntity> matieres, boolean isManager,
			RoleEntity roles, boolean enabled) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.addresse = addresse;
		this.telephone = telephone;
		this.imgfile = imgfile;
		this.apropos = apropos;
		this.ncin = ncin;
		this.status = status;
		this.classesEtudiant = classesEtudiant;
		this.cours = cours;
		this.matieres = matieres;
		this.isManager = isManager;
		this.roles = roles;
		this.enabled = enabled;
	}
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String addresse;
	private String telephone;
	private String imgfile;
	private String apropos;
	private String ncin;
	private String status;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private ClasseEntity classesEtudiant;
	
	@OneToMany(mappedBy = "user")
	
    private List<CoursEntity> cours;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "user_matiere", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "matiere_id"))
	List<MatiereEntity> matieres=new ArrayList<>();
	
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isManager;
	@Enumerated(EnumType.STRING)
	private RoleEntity roles;
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean enabled;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	public RoleEntity getRoles() {
		return roles;
	}
	public void setRoles(RoleEntity roles) {
		this.roles = roles;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public ClasseEntity getClassesEtudiant() {
		return classesEtudiant;
	}
	public void setClassesEtudiant(ClasseEntity classesEtudiant) {
		this.classesEtudiant = classesEtudiant;
	}

	public List<CoursEntity> getCours() {
		return cours;
	}

	public void setCours(List<CoursEntity> cours) {
		this.cours = cours;
	}
	
}
