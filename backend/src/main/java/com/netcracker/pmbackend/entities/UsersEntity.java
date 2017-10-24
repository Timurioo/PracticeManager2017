package com.netcracker.pmbackend.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by dima on 10/24/2017.
 */
@Entity
@Table(name = "users", schema = "practicemanager", catalog = "")
public class UsersEntity {
    private int id;
    private String login;
    private String password;
    private String role;
    private Collection<HeadofpracticesEntity> headofpracticesById;
    private Collection<StudentsEntity> studentsesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 100)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role", nullable = false, length = 45)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (id != that.id) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<HeadofpracticesEntity> getHeadofpracticesById() {
        return headofpracticesById;
    }

    public void setHeadofpracticesById(Collection<HeadofpracticesEntity> headofpracticesById) {
        this.headofpracticesById = headofpracticesById;
    }

    @OneToMany(mappedBy = "usersByUserId")
    public Collection<StudentsEntity> getStudentsesById() {
        return studentsesById;
    }

    public void setStudentsesById(Collection<StudentsEntity> studentsesById) {
        this.studentsesById = studentsesById;
    }
}
