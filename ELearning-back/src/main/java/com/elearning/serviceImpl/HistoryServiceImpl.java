package com.elearning.serviceImpl;

import com.elearning.entities.HistoryEntity;
import com.elearning.repository.HistoryRepository;
import com.elearning.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryRepository historyRepository;


    @Override
    public HistoryEntity addHistory(HistoryEntity history) {
        return historyRepository.save(history);
    }

    @Override
    public HistoryEntity findHistoryByScore(int score) {
        return historyRepository.findHistoryByScore(score);
    }

    @Override
    public HistoryEntity findHistoryByUsername(String username) {
        return historyRepository.findHistoryByUsername(username);
    }

    @Override
    public List<HistoryEntity> getHistories() {
        List<HistoryEntity> histories = historyRepository.findAll();
        histories.sort((f1, f2) -> Long.compare(f2.getScore(), f1.getScore()));
        return histories;
    }


}
