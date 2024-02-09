package com.elearning.service;
import com.elearning.dto.UserDetailDTO;
import com.elearning.dto.admin.CreateAdminDTO;
import com.elearning.entities.users.AdminEntity;


import java.util.Optional;

public interface AdminService {


    Optional<UserDetailDTO> addAdmin(CreateAdminDTO createAdminDTO);
    public AdminEntity findAdminByLogin(String email) ;
}
