package com.netcracker.pmbackend.impl.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by dima on 10/24/2017.
 */
@Entity
@Table(name = "speciality", schema = "practicemanager", catalog = "")
public class SpecialityEntity {
    private int id;
    private int facultyId;
    private String name;
    private Collection<PracticesEntity> practicesById;
    private FacultyEntity facultyByFacultyId;
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
    @Column(name = "faculty_id", nullable = false, insertable = false, updatable = false)
    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
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

        SpecialityEntity that = (SpecialityEntity) o;

        if (id != that.id) return false;
        if (facultyId != that.facultyId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + facultyId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "specialityBySpecialityId")
    public Collection<PracticesEntity> getPracticesById() {
        return practicesById;
    }

    public void setPracticesById(Collection<PracticesEntity> practicesById) {
        this.practicesById = practicesById;
    }

    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "id", nullable = false)
    public FacultyEntity getFacultyByFacultyId() {
        return facultyByFacultyId;
    }

    public void setFacultyByFacultyId(FacultyEntity facultyByFacultyId) {
        this.facultyByFacultyId = facultyByFacultyId;
    }

    @OneToMany(mappedBy = "specialityBySpecialityId")
    public Collection<StudentsEntity> getStudentsesById() {
        return studentsesById;
    }

    public void setStudentsesById(Collection<StudentsEntity> studentsesById) {
        this.studentsesById = studentsesById;
    }
}
