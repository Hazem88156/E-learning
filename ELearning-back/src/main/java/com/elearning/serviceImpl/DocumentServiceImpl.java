package com.elearning.serviceImpl;

import com.elearning.dto.DocumentDTO;
import com.elearning.entities.CoursEntity;
import com.elearning.entities.DocumentEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.CoursRepository;
import com.elearning.repository.DocumentRepository;
import com.elearning.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



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

	public Optional<DocumentDTO> findDocumentById(long id) {
		// TODO: implémenter la logique pour rechercher un document par son ID
		Optional<DocumentEntity> document = documentRepository.findById(id);

		return document.map(documentEntity -> ModelMapperConverter.converToDTO(documentEntity, DocumentDTO.class));
	}

	public List<DocumentDTO> getDocumentsByUser(Long userId) {
		List<DocumentEntity> documents = documentRepository.findByCourUserId(userId);
		return ModelMapperConverter.convertAllToDTO(documents, DocumentDTO.class);
	}
	 public List<DocumentEntity> getDocumentsByCoursId(Long id) {
 	    CoursEntity cours = coursRepository.findById(id).orElse(null);
 	    if (cours != null) {
 	        List<DocumentEntity> documents = cours.getDocuments();
 	        return documents;
 	    }
 	    return new ArrayList<>();
 	}
	public void deleteDocument(Long id){
		documentRepository.deleteById(id);
	}

	public void update(DocumentEntity document) {
		// TODO Auto-generated method stub
		System.out.println(document);
		Optional<DocumentEntity> documentUpdated = documentRepository.findById(document.getId());
		DocumentEntity d = documentUpdated.get();
		d.setDocumentName(document.getDocumentName());
		if (document.getDocumentFile() != null) {
			d.setDocumentFile(document.getDocumentFile());
		}

		d.setCour(document.getCour());
		d.setRecap(document.getRecap());
		documentRepository.save(d);
	}
}
