package com.elearning.bootstrap;

import com.elearning.entities.Role;
import com.elearning.entities.users.AdminEntity;
import com.elearning.repository.users.AdminRepository;
import com.elearning.serviceImpl.CustomUserDetailsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitAdmin implements CommandLineRunner {


    private final AdminRepository adminRepository;
    private final CustomUserDetailsService customUserDetailsService;

    public InitAdmin(AdminRepository adminRepository, CustomUserDetailsService customUserDetailsService) {
        this.adminRepository = adminRepository;
        this.customUserDetailsService = customUserDetailsService;
    }


    @Override
    public void run(String... args) throws Exception {
        boolean isAdminExist = adminRepository.existsByRoles(Role.ADMIN);
        if (! isAdminExist) {
            AdminEntity admin = new AdminEntity();
            admin.setStatus("ACTIVE");
            admin.setEmail("admin@elearning.com");
            admin.setFirstName("Admin");
            admin.setLastName("ADMIN");
            admin.setImgfile("admin.png");
            admin.setPassword("admin");
            customUserDetailsService.saveUser(admin);
        }
    }
}
