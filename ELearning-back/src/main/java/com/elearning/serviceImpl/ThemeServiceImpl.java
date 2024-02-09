package com.elearning.serviceImpl;

import com.elearning.dto.ThemeDTO;
import com.elearning.dto.theme.ThemeListDto;
import com.elearning.entities.ThemeEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.ThemeRepository;
import com.elearning.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ThemeServiceImpl implements ThemeService
{
    @Autowired
    private ThemeRepository themeRepository;
    @Autowired
    private ModelMapperConverter modelMapperConverter;


    public ThemeListDto saveTheme(ThemeDTO themeDTO) {

        ThemeEntity themeEntity = themeRepository.save(ModelMapperConverter.converToEntity(themeDTO, ThemeEntity.class));
        // Ajouter la classe
        themeRepository.save(themeEntity);
        return ModelMapperConverter.converToDTO(themeEntity, ThemeListDto.class);

    }
    public List<ThemeListDto> getAll() {
        System.out.println("Get all Cours 11111...");
        return ModelMapperConverter.convertAllToDTO(themeRepository.findAll(),ThemeListDto.class);

    }
    public Optional<ThemeDTO> findThemeById(long id) {
        // TODO: implémenter la logique pour rechercher un document par son ID
        Optional<ThemeEntity> theme = themeRepository.findById(id);

        return theme.map(themeEntity -> ModelMapperConverter.converToDTO(themeEntity, ThemeDTO.class));
    }



    public void deleteTheme(Long id){
        themeRepository.deleteById(id);
    }
}
