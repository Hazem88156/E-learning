package com.elearning.service;

import com.elearning.dto.LevelDTO;
import com.elearning.dto.level.LevelListDTO;
import com.elearning.entities.LevelEntity;
import com.elearning.entities.ThemeEntity;

import java.util.List;
import java.util.Optional;

public interface LevelService {
    LevelListDTO addLevel(LevelDTO level, Long idTheme);

    public Optional<List<LevelListDTO>> getLevels(Long idTheme);

    LevelListDTO getLevel(Long idTheme);

    void deleteLevel(Long id);
}
