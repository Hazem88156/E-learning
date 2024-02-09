package com.elearning.service;

import com.elearning.dto.UserDetailDTO;
import com.elearning.dto.etudiant.ClasseEtudiantDto;
import com.elearning.dto.etudiant.CreateEtudiantDTO;
import com.elearning.dto.etudiant.UpdateEtudiantDTO;
import com.elearning.entities.users.EtudiantEntity;

import java.util.Optional;

public interface EtudiantService {

    Optional<UserDetailDTO> addEtudiant(CreateEtudiantDTO createEtudiantDTO);

    public EtudiantEntity findEtudiantByLogin(String email) ;

    public void updateEtudiant(Long id, UpdateEtudiantDTO etudiant);

    Optional<ClasseEtudiantDto> getClasseByEtudiantId(Long etudiantId);
}
