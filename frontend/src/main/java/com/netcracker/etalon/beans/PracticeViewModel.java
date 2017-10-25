package com.netcracker.etalon.beans;


public class PracticeViewModel {

    private String id;
    private HeadOfPracticeViewModel headOfPracticeViewModel;
    private String company;
    private String firstDate;
    private String finishDate;
    private String status;
    private String totalQuantity;
    private String availableQuantity;
    private String avrMark;
    private SpecialityViewModel specialityViewModel;
    private FacultyViewModel facultyViewModel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HeadOfPracticeViewModel getHeadOfPracticeViewModel() {
        return headOfPracticeViewModel;
    }

    public void setHeadOfPracticeViewModel(HeadOfPracticeViewModel headOfPracticeViewModel) {
        this.headOfPracticeViewModel = headOfPracticeViewModel;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(String totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public String getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(String availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getAvrMark() {
        return avrMark;
    }

    public void setAvrMark(String avrMark) {
        this.avrMark = avrMark;
    }

    public SpecialityViewModel getSpecialityViewModel() {
        return specialityViewModel;
    }

    public void setSpecialityViewModel(SpecialityViewModel specialityViewModel) {
        this.specialityViewModel = specialityViewModel;
    }

    public FacultyViewModel getFacultyViewModel() {
        return facultyViewModel;
    }

    public void setFacultyViewModel(FacultyViewModel facultyViewModel) {
        this.facultyViewModel = facultyViewModel;
    }
}
