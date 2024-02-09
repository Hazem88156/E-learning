package com.elearning.service;

import com.elearning.dto.QuestionDTO;
import com.elearning.dto.question.QuestionListDTO;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    QuestionListDTO addQuestion(QuestionDTO questionDTO, Long idLevel);



    public Optional<List<QuestionListDTO>> getQuestions(Long idLevel);

    void deleteQuestions(Long id);





}
