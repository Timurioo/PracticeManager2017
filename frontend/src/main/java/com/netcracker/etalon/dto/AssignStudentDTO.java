package com.netcracker.etalon.dto;


import java.util.List;

public class AssignStudentDTO {

    private String practiceId;
    private List<String> studentsIds;

    public AssignStudentDTO() {
    }

    public AssignStudentDTO(String practiceId, List<String> studentsIds) {
        this.practiceId = practiceId;
        this.studentsIds = studentsIds;
    }

    public String getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(String practiceId) {
        this.practiceId = practiceId;
    }

    public List<String> getStudentsIds() {
        return studentsIds;
    }

    public void setStudentsIds(List<String> studentsIds) {
        this.studentsIds = studentsIds;
    }
}
