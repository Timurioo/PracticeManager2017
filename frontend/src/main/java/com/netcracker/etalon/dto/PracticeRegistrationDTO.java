package com.netcracker.etalon.dto;


public class PracticeRegistrationDTO {

    private String company;
    private String headOfPracticeId;
    private String firstDate;
    private String finishDate;
    private String facultyId;
    private String specialityId;
    private String avrMark;
    private String totalQuantity;

    public PracticeRegistrationDTO() {
    }

    public PracticeRegistrationDTO(String company, String headOfPracticeId, String firstDate, String finishDate, String facultyId, String specialityId, String avrMark, String totalQuantity) {
        this.company = company;
        this.headOfPracticeId = headOfPracticeId;
        this.firstDate = firstDate;
        this.finishDate = finishDate;
        this.facultyId = facultyId;
        this.specialityId = specialityId;
        this.avrMark = avrMark;
        this.totalQuantity = totalQuantity;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getHeadOfPracticeId() {
        return headOfPracticeId;
    }

    public void setHeadOfPracticeId(String headOfPracticeId) {
        this.headOfPracticeId = headOfPracticeId;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getSpecialityId() {
        return specialityId;
    }

    public void setSpecialityId(String specialityId) {
        this.specialityId = specialityId;
    }

    public String getAvrMark() {
        return avrMark;
    }

    public void setAvrMark(String avrMark) {
        this.avrMark = avrMark;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
