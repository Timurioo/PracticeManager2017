package com.netcracker.etalon.beans;


public class AssignStudentViewModel {

    private String id;
    private StudentViewModel studentViewModel;
    private PracticeViewModel practiceViewModel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public StudentViewModel getStudentViewModel() {
        return studentViewModel;
    }

    public void setStudentViewModel(StudentViewModel studentViewModel) {
        this.studentViewModel = studentViewModel;
    }

    public PracticeViewModel getPracticeViewModel() {
        return practiceViewModel;
    }

    public void setPracticeViewModel(PracticeViewModel practiceViewModel) {
        this.practiceViewModel = practiceViewModel;
    }
}
