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
@Table(name = "options")
@Inheritance(strategy = InheritanceType.JOINED)
public class OptionEntity extends MyEntity implements Serializable{
	public OptionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OptionEntity(Long id, String text, boolean correct) {
		super();
		this.id = id;
		this.text = text;
		this.correct = correct;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private boolean correct;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

}
