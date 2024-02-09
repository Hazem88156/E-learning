package com.elearning.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class VideoDTO extends MyDTO implements Serializable{
	public VideoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VideoDTO(Long id, String vedioName, String vedioFile, CoursDTO cour,String recap) {
		super();
		this.id = id;
		this.vedioName = vedioName;
		this.vedioFile = vedioFile;
		this.cour = cour;
		this.recap = recap;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String vedioName;
	private String vedioFile;

	private String recap;

	private CoursDTO cour;
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
	public CoursDTO getCour() {
		return cour;
	}
	public void setCour(CoursDTO cour) {
		this.cour = cour;
	}

	public String getRecap() {
		return recap;
	}

	public void setRecap(String recap) {
		this.recap = recap;
	}
}
