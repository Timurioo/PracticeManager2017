package com.chekh.pmfrontend.validation.validator.message;

/**
 * Created by dima on 12/20/2017.
 */
public enum ErrorMessage {
    EMPTYFIELD("Should be not empty"),
    LOGININUSE("Login has been already in use"),
    PASSWORDINUSE("Password has been already in use"),
    EMAILINUSE("Email has been already in use"),
    PHONEINUSE("Phone has been already in use"),
    SPECIALITYEXIST("Speciality has been already registered"),
    COMPANYEXIST("Such company has been already registered"),
    FACULTYEXIST("Faculty has been already registered"),
    NAMEINUSE("Name has been already in use");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
