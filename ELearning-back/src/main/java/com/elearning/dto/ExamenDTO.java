package com.elearning.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.elearning.entities.CoursEntity;
import com.elearning.entities.QuestionEntity;

public class ExamenDTO  extends MyDTO implements Serializable{
	@ManyToOne(fetch=FetchType.LAZY)
	private CoursEntity cour;
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

}
