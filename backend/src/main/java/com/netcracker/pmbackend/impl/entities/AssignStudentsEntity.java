package com.netcracker.pmbackend.impl.entities;

import javax.persistence.*;

/**
 * Created by dima on 10/24/2017.
 */
@Entity
@Table(name = "assignstudents", schema = "practicemanager", catalog = "")
public class AssignStudentsEntity {
    private int id;
    private int studentId;
    private int practiceId;
    private StudentsEntity studentsByStudentId;
    private PracticesEntity practicesByPracticeId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "student_id", nullable = false, insertable = false, updatable = false)
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "practice_id", nullable = false, insertable = false, updatable = false)
    public int getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(int practiceId) {
        this.practiceId = practiceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssignStudentsEntity that = (AssignStudentsEntity) o;

        if (id != that.id) return false;
        if (studentId != that.studentId) return false;
        if (practiceId != that.practiceId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + studentId;
        result = 31 * result + practiceId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    public StudentsEntity getStudentsByStudentId() {
        return studentsByStudentId;
    }

    public void setStudentsByStudentId(StudentsEntity studentsByStudentId) {
        this.studentsByStudentId = studentsByStudentId;
    }

    @ManyToOne
    @JoinColumn(name = "practice_id", referencedColumnName = "id", nullable = false)
    public PracticesEntity getPracticesByPracticeId() {
        return practicesByPracticeId;
    }

    public void setPracticesByPracticeId(PracticesEntity practicesByPracticeId) {
        this.practicesByPracticeId = practicesByPracticeId;
    }

    @Override
    public String toString() {
        return "AssignStudentsEntity{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", practiceId=" + practiceId +
                ", studentsByStudentId=" + studentsByStudentId +
                ", practicesByPracticeId=" + practicesByPracticeId +
                '}';
    }
}
