package com.elearning.serviceImpl;

import com.elearning.dto.TpDTO;
import com.elearning.dto.UserDetailDTO;
import com.elearning.dto.prof.CreateProfDTO;
import com.elearning.entities.TpEntity;
import com.elearning.entities.users.ProfEntity;
import com.elearning.entities.users.UserEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.users.ProfRepository;
import com.elearning.service.ProfService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class ProfServiceImpl implements ProfService {
    private final ProfRepository profRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public ProfServiceImpl(ProfRepository profRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.profRepository = profRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Optional<UserDetailDTO> addProf(CreateProfDTO createProfDTO) {
        ProfEntity profEntity = ModelMapperConverter.converToEntity(createProfDTO, ProfEntity.class);
        String password = bCryptPasswordEncoder.encode(profEntity.getPassword());
        profEntity.setPassword(password);
        profEntity.setStatus("INACTIVE");
        profRepository.save(profEntity);
        return Optional.of(ModelMapperConverter.converToDTO(profEntity, UserDetailDTO.class));
    }

    public ProfEntity findProfByLogin(String email) {
        return profRepository.findByEmail(email);
    }

    public UserEntity findUserByFirstName(String firstName) {
        return profRepository.findByFirstName(firstName);
    }

    @Override
    public Optional<List<TpDTO>> findByProf(String email) {
        ProfEntity p = profRepository.findByEmail(email);
        if (p == null) {
            return Optional.empty();
        }
        List<TpEntity> tps = p.getCours()
                .stream()
                .flatMap(coursEntity -> coursEntity.getDocuments().stream())
                .flatMap(documentEntity -> documentEntity.getTps().stream())
                .collect(Collectors.toList());
        return Optional.of(ModelMapperConverter.convertAllToDTO(tps,TpDTO.class));
    }

}
