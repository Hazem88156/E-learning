package com.elearning.service;

import com.elearning.dto.UserDetailDTO;
import com.elearning.dto.assistant.CreateAssistantDTO;
import com.elearning.dto.etudiant.CreateEtudiantDTO;
import com.elearning.dto.prof.CreateProfDTO;
import com.elearning.entities.users.AssistantEntity;
import com.elearning.entities.users.ProfEntity;

import java.util.Optional;

public interface AssistantService {

    Optional<UserDetailDTO> addAssistant(CreateAssistantDTO createAssistantDTO);

    public AssistantEntity findAssistantByLogin(String email) ;
}
