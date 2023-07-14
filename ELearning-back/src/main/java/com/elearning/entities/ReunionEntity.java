package com.elearning.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;


@Entity
@Table(name = "reunion")
@Inheritance(strategy = InheritanceType.JOINED)
public class ReunionEntity  extends MyEntity implements Serializable{
	
	
	
	
	public ReunionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReunionEntity(Long id, String reunionName, String createur) {
		super();
		this.id = id;
		this.reunionName = reunionName;
		this.createur = createur;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reunionName;
	private String createur;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getReunionName() {
		return reunionName;
	}
	public void setReunionName(String reunionName) {
		this.reunionName = reunionName;
	}
	public String getCreateur() {
		return createur;
	}
	public void setCreateur(String createur) {
		this.createur = createur;
	}
		
	
}
