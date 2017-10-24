package com.netcracker.pmbackend.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by dima on 10/24/2017.
 */
@Entity
@Table(name = "headofpractices", schema = "practicemanager", catalog = "")
public class HeadofpracticesEntity {
    private int id;
    private int userId;
    private String name;
    private UsersEntity usersByUserId;
    private Collection<PracticesEntity> practicesById;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeadofpracticesEntity that = (HeadofpracticesEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UsersEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UsersEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    @OneToMany(mappedBy = "headofpracticesByHeadofpracticeId")
    public Collection<PracticesEntity> getPracticesById() {
        return practicesById;
    }

    public void setPracticesById(Collection<PracticesEntity> practicesById) {
        this.practicesById = practicesById;
    }
}
