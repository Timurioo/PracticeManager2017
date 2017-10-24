package com.netcracker.pmbackend.impl.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by dima on 10/24/2017.
 */
@Entity
@Table(name = "faculty", schema = "practicemanager", catalog = "")
public class FacultyEntity {
    private int id;
    private String name;
    private Collection<PracticesEntity> practicesById;
    private Collection<SpecialityEntity> specialitiesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
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

        FacultyEntity that = (FacultyEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "facultyByFacultyId")
    public Collection<PracticesEntity> getPracticesById() {
        return practicesById;
    }

    public void setPracticesById(Collection<PracticesEntity> practicesById) {
        this.practicesById = practicesById;
    }

    @OneToMany(mappedBy = "facultyByFacultyId")
    public Collection<SpecialityEntity> getSpecialitiesById() {
        return specialitiesById;
    }

    public void setSpecialitiesById(Collection<SpecialityEntity> specialitiesById) {
        this.specialitiesById = specialitiesById;
    }
}
