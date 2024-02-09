package com.elearning.serviceImpl;

import com.elearning.dto.QuestionDTO;
import com.elearning.dto.question.QuestionListDTO;
import com.elearning.entities.LevelEntity;
import com.elearning.entities.QuestionEntity;
import com.elearning.helper.ModelMapperConverter;
import com.elearning.repository.LevelRepository;
import com.elearning.repository.QuestionRepository;
import com.elearning.service.QuestionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    private QuestionService questionService;
    private final LevelRepository levelRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository, LevelRepository levelRepository) {
        this.questionRepository = questionRepository;
        this.levelRepository = levelRepository;
    }


    @Override
    public QuestionListDTO addQuestion(QuestionDTO questionDTO, Long idLevel) {
        LevelEntity level = levelRepository.findById(idLevel).orElseThrow(
                () -> new RuntimeException("Theme %s n'existe pas!")
        );
        QuestionEntity question = ModelMapperConverter.converToEntity(questionDTO, QuestionEntity.class);
        questionRepository.save(question);
        question.setLevel(level);
        questionRepository.save(question);
        return ModelMapperConverter.converToDTO(question, QuestionListDTO.class);
    }




    @Override
    public Optional<List<QuestionListDTO>> getQuestions(Long idLevel) {
        Optional<LevelEntity> levelEntityOptional = levelRepository.findById(idLevel);
        if (!levelEntityOptional.isPresent()) {
            return Optional.empty();
        }
        LevelEntity level = levelEntityOptional.get();
        List<QuestionEntity> questions = level.getQuestions();
        return Optional.of(ModelMapperConverter.convertAllToDTO(questions,QuestionListDTO.class));
    }

    public void deleteQuestions(Long id) {
        questionRepository.deleteById(id);
    }

}
