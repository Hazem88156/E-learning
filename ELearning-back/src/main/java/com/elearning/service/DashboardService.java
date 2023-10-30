package com.elearning.service;

import com.elearning.dto.dashboard.StatCountDto;

import java.util.Optional;

public interface DashboardService {

    Optional<StatCountDto> getStatCount();
}