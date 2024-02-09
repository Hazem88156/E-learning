package com.elearning.serviceImpl;

import com.elearning.dto.UserDetailDTO;
import com.elearning.dto.etudiant.ClasseEtudiantDto;
import com.elearning.dto.etudiant.CreateEtudiantDTO;
import com.elearning.dto.etudiant.UpdateEtudiantDTO;
import com.elearning.entities.users.EtudiantEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.users.EtudiantRepository;
import com.elearning.service.EtudiantService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class EtudiantServiceImp implements EtudiantService {

    private final EtudiantRepository etudiantRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public EtudiantServiceImp(EtudiantRepository etudiantRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.etudiantRepository = etudiantRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Optional<UserDetailDTO> addEtudiant(CreateEtudiantDTO createEtudiantDTO) {
        EtudiantEntity etudiantEntity = ModelMapperConverter.converToEntity(createEtudiantDTO, EtudiantEntity.class);
        String password = bCryptPasswordEncoder.encode(etudiantEntity.getPassword());
        etudiantEntity.setPassword(password);
        etudiantEntity.setStatus("INACTIVE");
        etudiantRepository.save(etudiantEntity);
        return Optional.of(ModelMapperConverter.converToDTO(etudiantEntity, UserDetailDTO.class));
    }

    public void updateEtudiant(Long id, UpdateEtudiantDTO etudiant) {
        Optional<EtudiantEntity> userUpdated = etudiantRepository.findById(id);
        EtudiantEntity u = userUpdated.get();

        u.setFirstName(etudiant.getFirstName());
        u.setEmail(etudiant.getEmail());
        u.setUsername(etudiant.getUsername());
        u.setLastName(etudiant.getLastName());
        u.setApropos(etudiant.getApropos());
        u.setStatus(etudiant.getStatus());
        u.setNcin(etudiant.getNcin());
        u.setClassesEtudiant(etudiant.getClassesEtudiant());
        u.setTelephone(etudiant.getTelephone());
        if (etudiant.getImgfile() != null) {
            u.setImgfile(etudiant.getImgfile());
        }
        etudiantRepository.save(u);


    }

    @Override
    public Optional<ClasseEtudiantDto> getClasseByEtudiantId(Long etudiantId) {
        return etudiantRepository.findById(etudiantId)
                .map(EtudiantEntity::getClassesEtudiant)
                .map(classeEntity -> ModelMapperConverter.converToDTO(classeEntity, ClasseEtudiantDto.class));
    }

    @Override
    public EtudiantEntity findEtudiantByLogin(String email) {
        return etudiantRepository.findByEmail(email);
    }
}
