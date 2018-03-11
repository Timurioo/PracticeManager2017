package com.chekh.pmfrontend.dto;

/**
 * Created by dima on 11/8/2017.
 */
public class StudentRegistrationDTO {

    private String name;
    private String surname;
    private String role;
    private String phone;
    private String email;
    private String facultyId;
    private String specialityId;
    private String group;
    private String avrMark;
    private String budget;
    private String login;
    private String password;

    public StudentRegistrationDTO() {
    }

    public StudentRegistrationDTO(String name, String surname, String role, String phone, String email, String facultyId, String specialityId, String group, String avrMark, String budget, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.facultyId = facultyId;
        this.specialityId = specialityId;
        this.group = group;
        this.avrMark = avrMark;
        this.budget = budget;
        this.login = login;
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(String specialityId) {
        this.specialityId = specialityId;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAvrMark() {
        return avrMark;
    }

    public void setAvrMark(String avrMark) {
        this.avrMark = avrMark;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
