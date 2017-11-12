package com.netcracker.etalon.dto;


public class SpecialityRegistrationDTO {

    private String name;
    private String facultyId;

    public SpecialityRegistrationDTO() {
    }

    public SpecialityRegistrationDTO(String name, String facultyId) {
        this.name = name;
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }
}
