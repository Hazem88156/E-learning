package com.elearning.entities.users;

import com.elearning.entities.MyEntity;
import com.elearning.entities.Role;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role", discriminatorType = DiscriminatorType.STRING)
public class UserEntity extends MyEntity implements Serializable {

    public UserEntity(Long id, String email, String username, String password, String firstName, String lastName, String addresse, String telephone, String imgfile, String apropos, String ncin, String status, Role role) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresse = addresse;
        this.telephone = telephone;
        this.imgfile = imgfile;
        this.apropos = apropos;
        this.ncin = ncin;
        this.status = status;
        this.roles = role;
    }

    public UserEntity() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String addresse;
    private String telephone;
    private String imgfile;
    private String apropos;
    private String ncin;
    private String status;
    @Column(insertable = false, updatable = false, name = "role")
    @Enumerated(EnumType.STRING)
    private Role roles;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }
}
