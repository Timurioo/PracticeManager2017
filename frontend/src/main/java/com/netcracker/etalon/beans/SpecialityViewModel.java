package com.netcracker.etalon.beans;


public class SpecialityViewModel {

    private String id;
    private String name;
    private FacultyViewModel facultyViewModel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FacultyViewModel getFacultyViewModel() {
        return facultyViewModel;
    }

    public void setFacultyViewModel(FacultyViewModel facultyViewModel) {
        this.facultyViewModel = facultyViewModel;
    }
}
