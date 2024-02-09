package com.elearning.serviceImpl;

import com.elearning.dto.LevelDTO;
import com.elearning.dto.level.LevelListDTO;
import com.elearning.entities.LevelEntity;
import com.elearning.entities.ThemeEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.LevelRepository;
import com.elearning.repository.ThemeRepository;
import com.elearning.service.LevelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {
    private final LevelRepository levelRepository;

    private LevelService levelService;
    private final ThemeRepository themeRepository;

    public LevelServiceImpl(LevelRepository levelRepository, ThemeRepository themeRepository) {
        this.levelRepository = levelRepository;
        this.themeRepository = themeRepository;
    }


    public LevelListDTO addLevel(LevelDTO levelDTO, Long idTheme) {
        ThemeEntity theme = themeRepository.findById(idTheme).orElseThrow(
                () -> new RuntimeException("Theme %s n'existe pas!")
        );
        LevelEntity level = ModelMapperConverter.converToEntity(levelDTO, LevelEntity.class);
        levelRepository.save(level);
        level.setTheme(theme);
        levelRepository.save(level);
        return ModelMapperConverter.converToDTO(level, LevelListDTO.class);
    }


    public Optional<List<LevelListDTO>> getLevels(Long idTheme) {
        Optional<ThemeEntity> themeEntityOptional = themeRepository.findById(idTheme);
        if (!themeEntityOptional.isPresent()) {
            return Optional.empty();
        }
        ThemeEntity theme = themeEntityOptional.get();
        List<LevelEntity> levels = theme.getLevels();
        return Optional.of(ModelMapperConverter.convertAllToDTO(levels,LevelListDTO.class));
    }

    @Override
    public LevelListDTO getLevel(Long idTheme) {

        return ModelMapperConverter.converToDTO(levelRepository.findById(idTheme).get(),LevelListDTO.class);
    }

    public void deleteLevel(Long id) {
        levelRepository.deleteById(id);
    }


}
