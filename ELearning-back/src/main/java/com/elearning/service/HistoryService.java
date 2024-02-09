package com.elearning.service;

import com.elearning.dto.HistoryDTO;
import com.elearning.entities.HistoryEntity;

import java.util.List;

public interface HistoryService {

    HistoryEntity addHistory(HistoryEntity history);

    HistoryEntity findHistoryByScore(int score);

    HistoryEntity findHistoryByUsername(String username);

    List<HistoryEntity> getHistories();





}
