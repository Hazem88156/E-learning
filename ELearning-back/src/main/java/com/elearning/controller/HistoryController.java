package com.elearning.controller;

import com.elearning.entities.HistoryEntity;
import com.elearning.service.HistoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/api")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @PostMapping("/addHistory")
    HistoryEntity addHistory(@RequestBody HistoryEntity history) {
        return historyService.addHistory(history);
    }

    @GetMapping("/findHistoryByScore/{score}")
    HistoryEntity findHistoryBySore(@PathVariable("score") int score) {
        return historyService.findHistoryByScore(score);
    }
    @GetMapping("/findHistoryByUsername/{username}")
    HistoryEntity findHistoryByUsername(@PathVariable("username") String username) {
        return historyService.findHistoryByUsername(username);
    }

    @GetMapping("/getHistories")
    List<HistoryEntity> getHistories() {
        return historyService.getHistories();
    }
}
