package com.elearning.controller;

import com.elearning.dto.QuestionDTO;
import com.elearning.dto.question.QuestionListDTO;
import com.elearning.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin()
@RequestMapping("/api")
public class QuestionController {
    private QuestionService questionService;

    @PostMapping("/addQuestion/{idLevel}")
    public QuestionListDTO addQuestion(@RequestBody QuestionDTO question, @PathVariable("idLevel") Long idLevel) {
        return questionService.addQuestion(question, idLevel);
    }

    @GetMapping("/getQuestions/{idLevel}")
    public ResponseEntity<List<QuestionListDTO>> getQuestions(@PathVariable("idLevel") Long idLevel) {
        return ResponseEntity.of(questionService.getQuestions(idLevel));
    }

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @DeleteMapping("/question/{id}")
    public void deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestions(id);
    }
}
