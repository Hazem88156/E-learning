package com.elearning.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "documents")
@Inheritance(strategy = InheritanceType.JOINED)
public class DocumentEntity extends MyEntity implements Serializable{
	
	
	
	
	@Override
	public String toString() {
		return "DocumentEntity [id=" + id + ", documentName=" + documentName + ", documentFile=" + documentFile + "]\n";
	}
	public DocumentEntity(Long id, String documentName, String documentFile, CoursEntity cour,String recap) {
		super();
		this.id = id;
		this.documentName = documentName;
		this.documentFile = documentFile;
		this.cour = cour;
		this.recap=recap;
	}
	public DocumentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String documentName;
	@JsonIgnoreProperties("documents")
	@JsonBackReference(value="tp-documents")
	@OneToMany(mappedBy="document",fetch=FetchType.LAZY)
	private List<TpEntity> tps;
	private String documentFile;
	@Column(length = 10000000)
	private String recap;
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
	public void setCour(CoursEntity cour) {
		this.cour = cour;
	}

	public String getRecap() {
		return recap;
	}

	public void setRecap(String recap) {
		this.recap = recap;
	}

	public List<TpEntity> getTps() {
		return tps;
	}
	public void setTps(List<TpEntity> tps) {
		this.tps = tps;
	}
}
