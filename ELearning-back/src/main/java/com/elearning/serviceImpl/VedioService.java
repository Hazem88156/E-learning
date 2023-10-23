package com.elearning.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.entities.CoursEntity;
import com.elearning.entities.DocumentEntity;
import com.elearning.entities.VedioEntity;
import com.elearning.repository.CoursRepository;
import com.elearning.repository.VedioRepository;
@Service
public class VedioService {
	@Autowired
	private VedioRepository vedioRepository;
	@Autowired
	private CoursRepository coursRepository;
    public void saveVedio(VedioEntity vedio) {
    	
		
        vedioRepository.save(vedio);
	}
	public List<VedioEntity> getAll() {
		System.out.println("Get all Vedio 11111...");
		return vedioRepository.findAll();
	}
	public Optional<VedioEntity> vediofindById(long id) {
		// TODO Auto-generated method stub
		return vedioRepository.findById(id);
	}
	/*public List<VedioEntity> getVediosByUser(Long userId) {
        return vedioRepository.findByCourUserId(userId);
    }*/
	 /*public List<VedioEntity> getVediosByCoursId(Long id) {
	 	    CoursEntity cours = coursRepository.findById(id).orElse(null);
	 	    if (cours != null) {
	 	        List<VedioEntity> vedios = cours.getVedios();
	 	        return vedios;
	 	    }
	 	    return new ArrayList<>();
	 	}*/

}
