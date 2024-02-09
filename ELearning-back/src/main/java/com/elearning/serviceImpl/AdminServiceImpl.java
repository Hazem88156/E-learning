package com.elearning.serviceImpl;

import com.elearning.dto.UserDetailDTO;
import com.elearning.dto.admin.CreateAdminDTO;
import com.elearning.entities.users.AdminEntity;
import com.elearning.repository.users.AdminRepository;
import com.elearning.service.AdminService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

;
@Transactional
@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public AdminServiceImpl(AdminRepository adminRepository, PasswordEncoder bCryptPasswordEncoder) {
        this.adminRepository = adminRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Optional<UserDetailDTO> addAdmin(CreateAdminDTO createAdminDTO) {
        return Optional.empty();
    }

    @Override
    public AdminEntity findAdminByLogin(String email) {
        return adminRepository.findByEmail(email);
    }
}
