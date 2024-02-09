package com.elearning.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "themes")
@Inheritance(strategy = InheritanceType.JOINED)
public class ThemeEntity extends MyEntity implements Serializable
{
    public ThemeEntity(Long id, String name, List<LevelEntity> levels) {
        this.id = id;
        this.name = name;
        this.levels = levels;
    }

    public ThemeEntity() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnoreProperties("cours")
    @ManyToOne(fetch=FetchType.EAGER)
    private CoursEntity cour;

    public CoursEntity getCour() {
        return cour;
    }

    public void setCour(CoursEntity cour) {
        this.cour = cour;
    }

    private String name;
    @JsonIgnoreProperties("theme")
    @JsonBackReference(value="theme-level")
    @OneToMany(mappedBy = "theme", fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private List<LevelEntity> levels;

    public ThemeEntity(String nom) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LevelEntity> getLevels() {
        return levels;
    }

    public void setLevels(List<LevelEntity> levels) {
        this.levels = levels;
    }

    public void addLevel(LevelEntity level) {
        if (getLevels() == null) {
            setLevels(new ArrayList<>());
        }
        if (!getLevels().contains(level)) {
            getLevels().add(level);
            level.setTheme(this);
        }
    }


}
