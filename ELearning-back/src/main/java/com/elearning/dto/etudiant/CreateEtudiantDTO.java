package com.elearning.dto.etudiant;

import com.elearning.dto.MyDTO;

public class CreateEtudiantDTO extends MyDTO {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String username;
    private String addresse;
    private String telephone;
    private String imgfile;
    private String apropos;
    private String ncin;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getImgfile() {
        return imgfile;
    }

    public void setImgfile(String imgfile) {
        this.imgfile = imgfile;
    }

    public String getApropos() {
        return apropos;
    }

    public void setApropos(String apropos) {
        this.apropos = apropos;
    }

    public String getNcin() {
        return ncin;
    }

    public void setNcin(String ncin) {
        this.ncin = ncin;
    }
}
