package com.elearning.service;

import com.elearning.dto.TpDTO;
import com.elearning.dto.UserDetailDTO;
import com.elearning.dto.prof.CreateProfDTO;
import com.elearning.entities.TpEntity;
import com.elearning.entities.users.ProfEntity;

import java.util.List;
import java.util.Optional;

public interface ProfService {
    Optional<UserDetailDTO> addProf(CreateProfDTO createProfDTO);

    public ProfEntity findProfByLogin(String email) ;

    public Optional<List<TpDTO>> findByProf(String email);
}
