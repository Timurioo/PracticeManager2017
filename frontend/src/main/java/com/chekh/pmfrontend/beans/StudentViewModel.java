package com.chekh.pmfrontend.beans;


public class StudentViewModel {

    private String id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private UserViewModel userViewModel;
    private SpecialityViewModel specialityViewModel;
    private String group;
    private String avrMark;
    private String budget;
    private String status;

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

    public UserViewModel getUserViewModel() {
        return userViewModel;
    }

    public void setUserViewModel(UserViewModel userViewModel) {
        this.userViewModel = userViewModel;
    }

    public SpecialityViewModel getSpecialityViewModel() {
        return specialityViewModel;
    }

    public void setSpecialityViewModel(SpecialityViewModel specialityViewModel) {
        this.specialityViewModel = specialityViewModel;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
