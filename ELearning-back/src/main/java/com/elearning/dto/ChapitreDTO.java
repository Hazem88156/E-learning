package com.elearning.dto;

import java.io.Serializable;


public class ChapitreDTO extends MyDTO implements Serializable{
	
	
	private Long id;
	private String chapitreName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getChapitreName() {
		return chapitreName;
	}
	public void setChapitreName(String chapitreName) {
		this.chapitreName = chapitreName;
	}

}
