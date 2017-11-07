package com.netcracker.etalon.dto;

/**
 * Created by dima on 11/7/2017.
 */
public class HeadOfPracticeRegistrationDTO {

    private String login;
    private String password;
    private String role;
    private String name;

    public HeadOfPracticeRegistrationDTO() {
    }

    public HeadOfPracticeRegistrationDTO(String login, String password, String role, String name) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.name = name;
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
}
