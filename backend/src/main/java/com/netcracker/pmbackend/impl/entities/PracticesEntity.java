package com.netcracker.pmbackend.impl.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by dima on 10/24/2017.
 */
@Entity
@Table(name = "practices", schema = "practicemanager", catalog = "")
public class PracticesEntity {
    private int id;
    private int headofpracticeId;
    private String company;
    private Date firstDate;
    private Date finishDate;
    private String status;
    private int totalQuantity;
    private int availableQuantity;
    private Double avrMark;
    private Integer specialityId;
    private Integer facultyId;
    private Collection<AssignstudentsEntity> assignstudentsesById;
    private HeadofpracticesEntity headofpracticesByHeadofpracticeId;
    private SpecialityEntity specialityBySpecialityId;
    private FacultyEntity facultyByFacultyId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "headofpractice_id", nullable = false, insertable = false, updatable = false)
    public int getHeadofpracticeId() {
        return headofpracticeId;
    }

    public void setHeadofpracticeId(int headofpracticeId) {
        this.headofpracticeId = headofpracticeId;
    }

    @Basic
    @Column(name = "company", nullable = false, length = 100)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "first_date", nullable = false)
    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    @Basic
    @Column(name = "finish_date", nullable = false)
    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "total_quantity", nullable = false)
    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    @Basic
    @Column(name = "available_quantity", nullable = false)
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Basic
    @Column(name = "avr_mark", nullable = true, precision = 0)
    public Double getAvrMark() {
        return avrMark;
    }

    public void setAvrMark(Double avrMark) {
        this.avrMark = avrMark;
    }

    @Basic
    @Column(name = "speciality_id", nullable = true, insertable = false, updatable = false)
    public Integer getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(Integer specialityId) {
        this.specialityId = specialityId;
    }

    @Basic
    @Column(name = "faculty_id", nullable = true, insertable = false, updatable = false)
    public Integer getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(Integer facultyId) {
        this.facultyId = facultyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PracticesEntity that = (PracticesEntity) o;

        if (id != that.id) return false;
        if (headofpracticeId != that.headofpracticeId) return false;
        if (totalQuantity != that.totalQuantity) return false;
        if (availableQuantity != that.availableQuantity) return false;
        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (firstDate != null ? !firstDate.equals(that.firstDate) : that.firstDate != null) return false;
        if (finishDate != null ? !finishDate.equals(that.finishDate) : that.finishDate != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (avrMark != null ? !avrMark.equals(that.avrMark) : that.avrMark != null) return false;
        if (specialityId != null ? !specialityId.equals(that.specialityId) : that.specialityId != null) return false;
        if (facultyId != null ? !facultyId.equals(that.facultyId) : that.facultyId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + headofpracticeId;
        result = 31 * result + (company != null ? company.hashCode() : 0);
        result = 31 * result + (firstDate != null ? firstDate.hashCode() : 0);
        result = 31 * result + (finishDate != null ? finishDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + totalQuantity;
        result = 31 * result + availableQuantity;
        result = 31 * result + (avrMark != null ? avrMark.hashCode() : 0);
        result = 31 * result + (specialityId != null ? specialityId.hashCode() : 0);
        result = 31 * result + (facultyId != null ? facultyId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "practicesByPracticeId")
    public Collection<AssignstudentsEntity> getAssignstudentsesById() {
        return assignstudentsesById;
    }

    public void setAssignstudentsesById(Collection<AssignstudentsEntity> assignstudentsesById) {
        this.assignstudentsesById = assignstudentsesById;
    }

    @ManyToOne
    @JoinColumn(name = "headofpractice_id", referencedColumnName = "id", nullable = false)
    public HeadofpracticesEntity getHeadofpracticesByHeadofpracticeId() {
        return headofpracticesByHeadofpracticeId;
    }

    public void setHeadofpracticesByHeadofpracticeId(HeadofpracticesEntity headofpracticesByHeadofpracticeId) {
        this.headofpracticesByHeadofpracticeId = headofpracticesByHeadofpracticeId;
    }

    @ManyToOne
    @JoinColumn(name = "speciality_id", referencedColumnName = "id")
    public SpecialityEntity getSpecialityBySpecialityId() {
        return specialityBySpecialityId;
    }

    public void setSpecialityBySpecialityId(SpecialityEntity specialityBySpecialityId) {
        this.specialityBySpecialityId = specialityBySpecialityId;
    }

    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "id")
    public FacultyEntity getFacultyByFacultyId() {
        return facultyByFacultyId;
    }

    public void setFacultyByFacultyId(FacultyEntity facultyByFacultyId) {
        this.facultyByFacultyId = facultyByFacultyId;
    }
}
