package com.elearning.dto.etudiant;

import com.elearning.dto.ClasseDTO;
import com.elearning.dto.UserDTO;
import com.elearning.entities.Role;


public class EtudiantDTO extends UserDTO {

    public EtudiantDTO(Long id, String email, String password, String firstName, String lastName, String username, Role roles, String addresse, String telephone, String imgfile, String apropos, String ncin, String status) {
        super(id, email, password, firstName, lastName, username, roles, addresse, telephone, imgfile, apropos, ncin, status);
    }

    public EtudiantDTO(ClasseDTO classesEtudiant) {
        this.classesEtudiant = classesEtudiant;
    }
    public EtudiantDTO(){

    }


    private ClasseDTO classesEtudiant;

    public ClasseDTO getClassesEtudiant() {
        return classesEtudiant;
    }

    public void setClassesEtudiant(ClasseDTO classesEtudiant) {
        this.classesEtudiant = classesEtudiant;
    }
}
