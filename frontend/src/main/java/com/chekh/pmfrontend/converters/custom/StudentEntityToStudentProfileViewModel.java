package com.chekh.pmfrontend.converters.custom;


import com.chekh.pmfrontend.beans.StudentProfileViewModel;
import com.chekh.pmbackend.impl.entities.AssignStudentsEntity;
import com.chekh.pmbackend.impl.entities.StudentsEntity;
import org.springframework.core.convert.converter.Converter;

public class StudentEntityToStudentProfileViewModel implements Converter<StudentsEntity, StudentProfileViewModel> {
    @Override
    public StudentProfileViewModel convert(StudentsEntity studentsEntity) {

        StudentProfileViewModel studentProfileViewModel = new StudentProfileViewModel();
        studentProfileViewModel.setId(String.valueOf(studentsEntity.getId()));
        studentProfileViewModel.setName(studentsEntity.getName());
        studentProfileViewModel.setSurname(studentsEntity.getSurname());
        studentProfileViewModel.setPhone(studentsEntity.getPhone());
        studentProfileViewModel.setEmail(studentsEntity.getEmail());
        studentProfileViewModel.setGroup(studentsEntity.getClassgroup());
        studentProfileViewModel.setAvrMark(String.valueOf(studentsEntity.getAvrMark()));
        studentProfileViewModel.setBudget(studentsEntity.getBudget());
        studentProfileViewModel.setStatus(studentsEntity.getStatus());

        studentProfileViewModel.setSpeciality(studentsEntity.getSpecialityBySpecialityId().getName());
        studentProfileViewModel.setFaculty(studentsEntity.getSpecialityBySpecialityId().getFacultyByFacultyId().getName());

        for(AssignStudentsEntity a : studentsEntity.getAssignstudentsesById()) {
            studentProfileViewModel.setCompany(a.getPracticesByPracticeId().getCompany());
            studentProfileViewModel.setPracticePeriod(String.valueOf(a.getPracticesByPracticeId().getFirstDate()) +" - "+String.valueOf(a.getPracticesByPracticeId().getFinishDate()));
        }

        return studentProfileViewModel;
    }
}
