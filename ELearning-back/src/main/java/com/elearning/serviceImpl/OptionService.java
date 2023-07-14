package com.elearning.serviceImpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.elearning.entities.OptionEntity;
import com.elearning.repository.OptionRepository;

@Service
@Transactional
public class OptionService {
	@Autowired
	private OptionRepository optionRepository;
	
public void saveOption(OptionEntity option) {
		
        optionRepository.save(option);
	}
	public List<OptionEntity> getAll() {
		System.out.println("Get all Options 11111...");
		return optionRepository.findAll();
	}
	public Optional<OptionEntity> optionfindById(long id) {
		// TODO Auto-generated method stub
		return optionRepository.findById(id);
	}


}
