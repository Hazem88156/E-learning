package com.elearning.entities.users;

import com.elearning.entities.ClasseEntity;
import com.elearning.entities.Role;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@DiscriminatorValue("ETUDIANT")
public class EtudiantEntity extends UserEntity implements Serializable {

    @ManyToOne(fetch=FetchType.EAGER)
    private ClasseEntity classesEtudiant;

    public EtudiantEntity(Long id, String email, String username, String password, String firstName, String lastName, String addresse, String telephone, String imgfile, String apropos, String ncin, String status, Role role, ClasseEntity classesEtudiant) {
        super(id, email, username, password, firstName, lastName, addresse, telephone, imgfile, apropos, ncin, status, role);
        this.classesEtudiant = classesEtudiant;
    }

    public EtudiantEntity() {
    }

    public ClasseEntity getClassesEtudiant() {
        return classesEtudiant;
    }

    public void setClassesEtudiant(ClasseEntity classesEtudiant) {
        this.classesEtudiant = classesEtudiant;
    }
}
