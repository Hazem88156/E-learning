package com.elearning.service;

import java.util.List;

import com.elearning.dto.DocumentDTO;


public interface DocumentService {
	
    public List<DocumentDTO> findAllDocument();
	
	public void addDocument (DocumentDTO document);

}
