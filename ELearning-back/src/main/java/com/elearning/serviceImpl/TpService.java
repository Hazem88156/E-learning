package com.elearning.serviceImpl;

import com.elearning.dto.TpDTO;
import com.elearning.entities.TpEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.TpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TpService {
    @Autowired
    private TpRepository tpRepository;
    @Autowired
    private ModelMapperConverter modelMapperConverter;

    public void saveTp(TpEntity tp) {
        tpRepository.save(tp);
    }
    public List<TpEntity> getAll() {
        System.out.println("Get all Tp 11111...");
        return tpRepository.findAll();
    }
    public Optional<TpDTO> tpfindById(long id) {
        // TODO: implémenter la logique pour rechercher un document par son ID
        Optional<TpEntity> tp = tpRepository.findById(id);

        if (tp.isPresent()) {
            return Optional.of(modelMapperConverter.converToDTO(tp.get(), TpDTO.class));
        } else {
            return Optional.empty();
        }
    }
    public void update(TpEntity tp) {
        // TODO Auto-generated method stub
        System.out.println(tp);
        Optional<TpEntity> tpUpdated = tpRepository.findById(tp.getId());
        TpEntity t = tpUpdated.get();
        t.setNom(tp.getNom());
        t.setLien(tp.getLien());
        if (tp.getTpFile() != null) {
            t.setTpFile(tp.getTpFile());
        }
        t.setDocument(tp.getDocument());

        tpRepository.save(t);
    }
    public List<TpDTO> getTpByUser(Long userId) {
        List<TpEntity> tps = tpRepository.findByDocumentCourUserId(userId);
        return modelMapperConverter.convertAllToDTO(tps, TpDTO.class);
    }
    public void deleteTp(Long id){
        tpRepository.deleteById(id);
    }


}
