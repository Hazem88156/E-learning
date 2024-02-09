package com.elearning.repository.users;

import com.elearning.entities.Role;
import com.elearning.entities.VedioEntity;
import com.elearning.entities.users.EtudiantEntity;
import com.elearning.entities.users.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<EtudiantEntity, Long> {

    EtudiantEntity findByEmail(String email);
    EtudiantEntity findByFirstName(String firstName);

    List<EtudiantEntity> findByRoles(Role role);


}
