package com.elearning.dto.dashboard;

public class StatCountDto {
    private Long userCount;
    private Long profCount;

    private Long studentCount;
    private Long courseCount;
    private Long matiereCount;
    private Long classCount;


    public StatCountDto() {
    }

    public StatCountDto(Long userCount, Long profCount, Long studentCount, Long courseCount, Long matiereCount, Long classCount) {
        this.userCount = userCount;
        this.profCount = profCount;
        this.studentCount = studentCount;
        this.courseCount = courseCount;
        this.matiereCount = matiereCount;
        this.classCount = classCount;
    }


    public Long getMatiereCount() {
        return matiereCount;
    }

    public void setMatiereCount(Long matiereCount) {
        this.matiereCount = matiereCount;
    }

    public Long getUserCount() {
        return userCount;
    }

    public void setUserCount(Long userCount) {
        this.userCount = userCount;
    }

    public Long getProfCount() {
        return profCount;
    }

    public void setProfCount(Long profCount) {
        this.profCount = profCount;
    }

    public Long getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(Long studentCount) {
        this.studentCount = studentCount;
    }

    public Long getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(Long courseCount) {
        this.courseCount = courseCount;
    }

    public Long getClassCount() {
        return classCount;
    }

    public void setClassCount(Long classCount) {
        this.classCount = classCount;
    }
}
