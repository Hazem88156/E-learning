package com.elearning.dto;

import java.io.Serializable;



public class QuestionDTO extends MyDTO implements Serializable{
	
	public QuestionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QuestionDTO(Long id, String libelleQuestion) {
		super();
		this.id = id;
		this.libelleQuestion = libelleQuestion;
	}
	private Long id;
	private String libelleQuestion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLibelleQuestion() {
		return libelleQuestion;
	}
	public void setLibelleQuestion(String libelleQuestion) {
		this.libelleQuestion = libelleQuestion;
	}

}
