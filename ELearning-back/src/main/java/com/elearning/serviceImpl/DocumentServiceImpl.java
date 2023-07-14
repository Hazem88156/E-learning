package com.elearning.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elearning.dto.DocumentDTO;
import com.elearning.entities.CoursEntity;
import com.elearning.entities.DocumentEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.CoursRepository;
import com.elearning.repository.DocumentRepository;
import com.elearning.service.DocumentService;



@Service
@Transactional
public class DocumentServiceImpl implements DocumentService{
	@Autowired
	private DocumentRepository documentRepository;
	@Autowired
	private CoursRepository coursRepository;
	@Autowired
	private ModelMapperConverter modelMapperConverter;
	@Override
	public List<DocumentDTO> findAllDocument() {
		// TODO Auto-generated method stub
		return modelMapperConverter.convertAllToDTO(documentRepository.findAll(),DocumentDTO.class);
	}

	@Override
	public void addDocument(DocumentDTO document) {
		// TODO Auto-generated method stub
		documentRepository.save(modelMapperConverter.converToEntity(document, DocumentEntity.class));
		
	}
	public void saveDocument(DocumentEntity document) {
		
        documentRepository.save(document);
	}
	public List<DocumentEntity> getAll() {
		System.out.println("Get all Cours 11111...");
		return documentRepository.findAll();
	}
	public Optional<DocumentEntity> documentfindById(long id) {
		// TODO Auto-generated method stub
		return documentRepository.findById(id);
	}

	public List<DocumentEntity> getDocumentsByUser(Long userId) {
        return documentRepository.findByCourUserId(userId);
    }
	 public List<DocumentEntity> getDocumentsByCoursId(Long id) {
 	    CoursEntity cours = coursRepository.findById(id).orElse(null);
 	    if (cours != null) {
 	        List<DocumentEntity> documents = cours.getDocuments();
 	        return documents;
 	    }
 	    return new ArrayList<>();
 	}
 	 
	
}
