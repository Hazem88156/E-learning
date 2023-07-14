package com.elearning.dto;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.elearning.entities.CoursEntity;

public class VideoDTO extends MyDTO implements Serializable{
	public VideoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VideoDTO(Long id, String vedioName, String vedioFile, CoursEntity cour) {
		super();
		this.id = id;
		this.vedioName = vedioName;
		this.vedioFile = vedioFile;
		this.cour = cour;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String vedioName;
	private String vedioFile;
	@ManyToOne(fetch=FetchType.EAGER)
	private CoursEntity cour;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVedioName() {
		return vedioName;
	}
	public void setVedioName(String vedioName) {
		this.vedioName = vedioName;
	}
	public String getVedioFile() {
		return vedioFile;
	}
	public void setVedioFile(String vedioFile) {
		this.vedioFile = vedioFile;
	}
	public CoursEntity getCour() {
		return cour;
	}
	public void setCour(CoursEntity cour) {
		this.cour = cour;
	}
}
