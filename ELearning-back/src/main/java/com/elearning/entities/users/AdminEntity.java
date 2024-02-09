package com.elearning.entities.users;

import com.elearning.entities.Role;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("ADMIN")
public class AdminEntity extends UserEntity implements Serializable {
    public AdminEntity(Long id, String email, String username, String password, String firstName, String lastName, String addresse, String telephone, String imgfile, String apropos, String ncin, String status, Role role) {
        super(id, email, username, password, firstName, lastName, addresse, telephone, imgfile, apropos, ncin, status, role);
    }

    public AdminEntity() {
    }
}
