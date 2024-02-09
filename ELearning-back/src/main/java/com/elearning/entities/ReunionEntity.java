package com.elearning.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "reunion")
@Inheritance(strategy = InheritanceType.JOINED)
public class ReunionEntity  extends MyEntity implements Serializable{
	
	
	
	
	public ReunionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReunionEntity(Long id, String reunionName) {
		super();
		this.id = id;
		this.reunionName = reunionName;

	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reunionName;

	@JsonIgnoreProperties("cours")
	@ManyToOne(fetch=FetchType.EAGER)
	private CoursEntity cour;

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


	public CoursEntity getCour() {
		return cour;
	}

	public void setCour(CoursEntity cour) {
		this.cour = cour;
	}
}
