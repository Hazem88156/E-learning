package com.elearning.entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name = "documents")
@Inheritance(strategy = InheritanceType.JOINED)
public class DocumentEntity extends MyEntity implements Serializable{
	
	
	
	
	@Override
	public String toString() {
		return "DocumentEntity [id=" + id + ", documentName=" + documentName + ", documentFile=" + documentFile + "]\n";
	}
	public DocumentEntity(Long id, String documentName, String documentFile, CoursEntity cour) {
		super();
		this.id = id;
		this.documentName = documentName;
		this.documentFile = documentFile;
		this.cour = cour;
	}
	public DocumentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String documentName;
	private String documentFile;
	@JsonIgnoreProperties("cours")
	@ManyToOne(fetch=FetchType.EAGER)
	private CoursEntity cour;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public CoursEntity getCour() {
		return cour;
	}
	public void setCours(CoursEntity cour) {
		this.cour = cour;
	}
	
}
