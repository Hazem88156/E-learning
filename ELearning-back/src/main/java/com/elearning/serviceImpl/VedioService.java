package com.elearning.serviceImpl;

import com.elearning.dto.VideoDTO;
import com.elearning.entities.VedioEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.CoursRepository;
import com.elearning.repository.VedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VedioService {
	@Autowired
	private VedioRepository vedioRepository;
	@Autowired
	private CoursRepository coursRepository;
	@Autowired
	private ModelMapperConverter modelMapperConverter;
    public void saveVedio(VedioEntity vedio) {
    	
		
        vedioRepository.save(vedio);
	}
	public List<VedioEntity> getAll() {
		System.out.println("Get all Vedio 11111...");
		return vedioRepository.findAll();
	}

	public List<VedioEntity> getVediosByUser(Long userId) {
        return vedioRepository.findByCourUserId(userId);
    }
	 /*public List<VedioEntity> getVediosByCoursId(Long id) {
	 	    CoursEntity cours = coursRepository.findById(id).orElse(null);
	 	    if (cours != null) {
	 	        List<VedioEntity> vedios = cours.getVedios();
	 	        return vedios;
	 	    }
	 	    return new ArrayList<>();
	 	}*/
	 public List<VideoDTO> getVideoByUser(Long userId) {
		 List<VedioEntity> videos = vedioRepository.findByCourUserId(userId);
		 return modelMapperConverter.convertAllToDTO(videos, VideoDTO.class);
	 }
	public Optional<VideoDTO> vediofindById(long id) {
		// TODO: implémenter la logique pour rechercher un document par son ID
		Optional<VedioEntity> video = vedioRepository.findById(id);

		if (video.isPresent()) {
			return Optional.of(modelMapperConverter.converToDTO(video.get(), VideoDTO.class));
		} else {
			return Optional.empty();
		}
	}
	public void update(VedioEntity video) {
		// TODO Auto-generated method stub
		System.out.println(video);
		Optional<VedioEntity> vedioUpdated = vedioRepository.findById(video.getId());
		VedioEntity v = vedioUpdated.get();
		v.setVedioName(video.getVedioName());
		if (video.getVedioFile() != null) {
			v.setVedioFile(video.getVedioFile());
		}
		v.setCour(video.getCour());
		v.setRecap(video.getRecap());
		vedioRepository.save(v);
	}
	public void deleteVedio(Long id){
		vedioRepository.deleteById(id);
	}
}
