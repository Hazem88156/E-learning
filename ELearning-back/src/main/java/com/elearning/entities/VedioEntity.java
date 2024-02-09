package com.elearning.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "vedios")
@Inheritance(strategy = InheritanceType.JOINED)
public class VedioEntity extends MyEntity implements Serializable{
	public VedioEntity(Long id, String vedioName, String vedioFile, CoursEntity cour,String recap) {
		super();
		this.id = id;
		this.vedioName = vedioName;
		this.vedioFile = vedioFile;
		this.cour = cour;
		this.recap=recap;
	}
	public VedioEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String vedioName;
	private String vedioFile;
	@Column(columnDefinition = "TEXT")
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

	public String getRecap() {
		return recap;
	}

	public void setRecap(String recap) {
		this.recap = recap;
	}
}
