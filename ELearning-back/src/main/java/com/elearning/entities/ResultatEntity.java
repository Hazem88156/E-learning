package com.elearning.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resultat")
@Inheritance(strategy = InheritanceType.JOINED)
public class ResultatEntity extends MyEntity implements Serializable{
	public ResultatEntity(Long id, UserEntity etudiant, int point) {
		super();
		this.id = id;
		this.etudiant = etudiant;
		this.point = point;
	}
	public ResultatEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private UserEntity etudiant;
	private int point;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserEntity getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(UserEntity etudiant) {
		this.etudiant = etudiant;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

}
