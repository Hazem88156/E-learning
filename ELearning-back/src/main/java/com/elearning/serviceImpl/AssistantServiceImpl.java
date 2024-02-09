package com.elearning.serviceImpl;

import com.elearning.dto.UserDetailDTO;
import com.elearning.dto.assistant.CreateAssistantDTO;
import com.elearning.entities.users.AssistantEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.users.AssistantRepository;
import com.elearning.service.AssistantService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Service
public class AssistantServiceImpl implements AssistantService {
    private final AssistantRepository assistantRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public AssistantServiceImpl(AssistantRepository assistantRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.assistantRepository = assistantRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Optional<UserDetailDTO> addAssistant(CreateAssistantDTO createAssistantDTO) {
        AssistantEntity assistantEntity = ModelMapperConverter.converToEntity(createAssistantDTO, AssistantEntity.class);
        String password = bCryptPasswordEncoder.encode(assistantEntity.getPassword());
        assistantEntity.setPassword(password);
        assistantEntity.setStatus("INACTIVE");
        assistantRepository.save(assistantEntity);
        return Optional.of(ModelMapperConverter.converToDTO(assistantEntity, UserDetailDTO.class));
    }

    @Override
    public AssistantEntity findAssistantByLogin(String email) {
        return assistantRepository.findByEmail(email);
    }
}
