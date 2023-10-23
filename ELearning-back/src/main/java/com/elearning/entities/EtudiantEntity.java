package com.elearning.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "etudiant")
@Inheritance(strategy = InheritanceType.JOINED)
public class EtudiantEntity extends UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public EtudiantEntity(Long id, String email, String username, String password, String firstName, String lastName, String addresse, String telephone, String imgfile, String apropos, String ncin, String status, ClasseEntity classesEtudiant, boolean isManager, RoleEntity roles, boolean enabled, Long id1) {
        super(id, email, username, password, firstName, lastName, addresse, telephone, imgfile, apropos, ncin, status, classesEtudiant, isManager, roles, enabled);
        this.id = id1;
    }

}
