package com.netcracker.etalon.dto;

/**
 * Created by dima on 11/8/2017.
 */
public class FacultyRegistrationDTO {

    private String name;
    private String facultyId;

    public FacultyRegistrationDTO() {
    }

    public FacultyRegistrationDTO(String name, String facultyId) {
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
