package com.elearning.entities;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "exam")
@Inheritance(strategy = InheritanceType.JOINED)
  public class ExamenEntity  extends MyEntity implements Serializable{
	public ExamenEntity(Long id, CoursEntity cour, List<QuestionEntity> questions, String examenName) {
		super();
		this.id = id;
		this.cour = cour;
		this.questions = questions;
		this.examenName = examenName;
	}
	public ExamenEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExamenEntity(CoursEntity cour, List<QuestionEntity> questions, String examenName) {
		super();
		this.cour = cour;
		this.questions = questions;
		this.examenName = examenName;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	private CoursEntity cour;
	@OneToMany(mappedBy="examen")
	private List<QuestionEntity> questions;
	private String examenName;
	public CoursEntity getCour() {
		return cour;
	}
	public void setCour(CoursEntity cour) {
		this.cour = cour;
	}
	public List<QuestionEntity> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuestionEntity> questions) {
		this.questions = questions;
	}
	public String getExamenName() {
		return examenName;
	}
	public void setExamenName(String examenName) {
		this.examenName = examenName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

  }
