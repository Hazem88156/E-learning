package com.elearning.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "question")
@Inheritance(strategy = InheritanceType.JOINED)
public class QuestionEntity extends MyEntity implements Serializable{
	
	
	

	public QuestionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionEntity(Long id, String questionText, ExamenEntity examen, List<OptionEntity> options,
			String explanation) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.examen = examen;
		this.options = options;
		this.explanation = explanation;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String questionText;
	@JsonIgnore
	 @ManyToOne()
	 @JoinColumn(name = "examen")
	 private ExamenEntity examen;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private List<OptionEntity> options;

    private String explanation;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<OptionEntity> getOptions() {
		return options;
	}

	public void setOptions(List<OptionEntity> options) {
		this.options = options;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public ExamenEntity getExamen() {
		return examen;
	}

	public void setExamen(ExamenEntity examen) {
		this.examen = examen;
	}

}
