package com.elearning.repository;

import com.elearning.entities.HistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {

    HistoryEntity findHistoryByScore(int score);

    HistoryEntity findHistoryByUsername(String username);
}
