package com.elearning.entities.users;

import com.elearning.entities.CoursEntity;
import com.elearning.entities.Role;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("PROFESSEUR")
public class ProfEntity extends UserEntity implements Serializable {
    public ProfEntity(Long id, String email, String username, String password, String firstName, String lastName, String addresse, String telephone, String imgfile, String apropos, String ncin, String status, Role role) {
        super(id, email, username, password, firstName, lastName, addresse, telephone, imgfile, apropos, ncin, status, role);
    }

    public ProfEntity() {
    }
    @OneToMany(mappedBy = "user") // Bidirectional relationship
    private List<CoursEntity> cours;

    public List<CoursEntity> getCours() {
        return cours;
    }

    public void setCours(List<CoursEntity> cours) {
        this.cours = cours;
    }
}