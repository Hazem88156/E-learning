package com.elearning.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


public class DocumentDTO extends MyDTO implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String documentName;
	private String documentFile;
	@Column(length=10000000)
	private String recap;
    

	private CoursDTO cour;

	public Long getId() {
		return id;
	}
	public String getDocumentName() {
		return documentName;
	}
	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}
	public String getDocumentFile() {
		return documentFile;
	}
	public void setDocumentFile(String documentFile) {
		this.documentFile = documentFile;
	}

	public void setId(Long id) {
		this.id = id;
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
