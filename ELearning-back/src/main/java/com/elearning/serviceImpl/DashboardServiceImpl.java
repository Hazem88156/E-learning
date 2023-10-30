package com.elearning.serviceImpl;

import com.elearning.dto.dashboard.StatCountDto;
import com.elearning.repository.*;
import com.elearning.service.DashboardService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final UserRepository userRepository;
    private final ProfRepository profRepository;
    private final EtudiantRepository etudiantRepository;
    private final CoursRepository coursRepository;
    private final ClasseRepository classeRepository;
    private final MatiereRepository matiereRepository;


    public DashboardServiceImpl(UserRepository userRepository, ProfRepository profRepository, EtudiantRepository etudiantRepository, CoursRepository coursRepository,ClasseRepository classeRepository, MatiereRepository matiereRepository) {
        this.userRepository = userRepository;
        this.profRepository = profRepository;
        this.etudiantRepository = etudiantRepository;
        this.coursRepository = coursRepository;
        this.classeRepository = classeRepository;
        this.matiereRepository = matiereRepository;
    }

    @Override
    public Optional<StatCountDto> getStatCount() {
        StatCountDto statCountDto = new StatCountDto();
        statCountDto.setUserCount(userRepository.count());
        statCountDto.setStudentCount(etudiantRepository.count());
        statCountDto.setProfCount(profRepository.count());
        statCountDto.setMatiereCount(matiereRepository.count());
        statCountDto.setClassCount(classeRepository.count());
        statCountDto.setCourseCount(coursRepository.count());
        return Optional.of(statCountDto);
    }
}
