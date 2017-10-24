package com.netcracker.pmbackend.impl.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by dima on 10/24/2017.
 */
@Entity
@Table(name = "students", schema = "practicemanager", catalog = "")
public class StudentsEntity {
    private int id;
    private int userId;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private int specialityId;
    private String group;
    private double avrMark;
    private byte budget;
    private String status;
    private Collection<AssignstudentsEntity> assignstudentsesById;
    private UsersEntity usersByUserId;
    private SpecialityEntity specialityBySpecialityId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false, insertable = false, updatable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 100)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 45)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "speciality_id", nullable = false, insertable = false, updatable = false)
    public int getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(int specialityId) {
        this.specialityId = specialityId;
    }

    @Basic
    @Column(name = "group", nullable = false, length = 45)
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Basic
    @Column(name = "avr_mark", nullable = false, precision = 0)
    public double getAvrMark() {
        return avrMark;
    }

    public void setAvrMark(double avrMark) {
        this.avrMark = avrMark;
    }

    @Basic
    @Column(name = "budget", nullable = false)
    public byte getBudget() {
        return budget;
    }

    public void setBudget(byte budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsEntity that = (StudentsEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (specialityId != that.specialityId) return false;
        if (Double.compare(that.avrMark, avrMark) != 0) return false;
        if (budget != that.budget) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (group != null ? !group.equals(that.group) : that.group != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + userId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + specialityId;
        result = 31 * result + (group != null ? group.hashCode() : 0);
        temp = Double.doubleToLongBits(avrMark);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) budget;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "studentsByStudentId" )
    public Collection<AssignstudentsEntity> getAssignstudentsesById() {
        return assignstudentsesById;
    }

    public void setAssignstudentsesById(Collection<AssignstudentsEntity> assignstudentsesById) {
        this.assignstudentsesById = assignstudentsesById;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "speciality_id", referencedColumnName = "id", nullable = false)
    public SpecialityEntity getSpecialityBySpecialityId() {
        return specialityBySpecialityId;
    }

    public void setSpecialityBySpecialityId(SpecialityEntity specialityBySpecialityId) {
        this.specialityBySpecialityId = specialityBySpecialityId;
    }
}
