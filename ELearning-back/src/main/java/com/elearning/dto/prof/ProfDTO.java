package com.elearning.dto.prof;

import com.elearning.dto.CoursDTO;

import javax.persistence.OneToMany;
import java.util.List;

public class ProfDTO extends CreateProfDTO{

    public ProfDTO(String email, String password, String firstName, String lastName, String username, String addresse, String telephone, String imgfile, String apropos, String ncin, List<CoursDTO> cours) {
        super(email, password, firstName, lastName, username, addresse, telephone, imgfile, apropos, ncin);
        this.cours = cours;
    }
    public ProfDTO(){

    }
    @OneToMany(mappedBy = "user") // Bidirectional relationship
    private List<CoursDTO> cours;

    public List<CoursDTO> getCours() {
        return cours;
    }

    public void setCours(List<CoursDTO> cours) {
        this.cours = cours;
    }
}
