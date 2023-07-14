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
@Table(name = "chapitre")
@Inheritance(strategy = InheritanceType.JOINED)
public class ChapitreEntity  extends MyEntity implements Serializable{

	public ChapitreEntity(Long id, String chapitreName) {
		super();
		this.id = id;
		this.chapitreName = chapitreName;
	}
	public ChapitreEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String chapitreName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getChapitreName() {
		return chapitreName;
	}
	public void setChapitreName(String chapitreName) {
		this.chapitreName = chapitreName;
	}
}
