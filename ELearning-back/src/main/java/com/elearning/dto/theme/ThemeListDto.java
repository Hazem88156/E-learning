package com.elearning.dto.theme;

import com.elearning.dto.MyDTO;


public class ThemeListDto extends MyDTO {


    private Long id;

    private CoursThemeDto cour;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CoursThemeDto getCour() {
        return cour;
    }

    public void setCour(CoursThemeDto cour) {
        this.cour = cour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ThemeListDto(Long id, CoursThemeDto cour, String name) {
        this.id = id;
        this.cour = cour;
        this.name = name;
    }

    public ThemeListDto() {
    }
}
