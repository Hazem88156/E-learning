package com.elearning.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "question")
@Inheritance(strategy = InheritanceType.JOINED)
public class QuestionEntity extends MyEntity implements Serializable{

	public QuestionEntity(Long id, String question, String response1, String response2, String response3, String correct, LevelEntity level) {
		this.id = id;
		this.question = question;
		this.response1 = response1;
		this.response2 = response2;
		this.response3 = response3;
		this.correct = correct;
		this.level = level;
	}
	
	

	public QuestionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String question;

	private String response1;

	private String response2;

	private String response3;



	private String correct;

	@ManyToOne
	private LevelEntity level;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getResponse1() {
		return response1;
	}

	public void setResponse1(String response1) {
		this.response1 = response1;
	}

	public String getResponse2() {
		return response2;
	}

	public void setResponse2(String response2) {
		this.response2 = response2;
	}

	public String getResponse3() {
		return response3;
	}

	public void setResponse3(String response3) {
		this.response3 = response3;
	}

	public String getCorrect() {
		return correct;
	}

	public void setCorrect(String correct) {
		this.correct = correct;
	}

	public LevelEntity getLevel() {
		return level;
	}

	public void setLevel(LevelEntity level) {
		this.level = level;
	}


}
