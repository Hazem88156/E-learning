package com.elearning.serviceImpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elearning.entities.ResultatEntity;
import com.elearning.repository.ResultatRepository;
import com.elearning.repository.UserRepository;

@Service
@Transactional
public class ResultatService {
	@Autowired
	private ResultatRepository resultatRepository;
    @Autowired
    private UserRepository userRepository;
  public ResultatEntity saveResultat(ResultatEntity resultat) {
	  	
		resultat.setEtudiant(
				userRepository.findById(resultat.getEtudiant().getId()).get()
		);
        resultatRepository.save(resultat);
        return resultat;
	}
}
