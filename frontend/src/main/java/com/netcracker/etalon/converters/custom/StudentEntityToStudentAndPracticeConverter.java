package com.netcracker.etalon.converters.custom;


import com.netcracker.etalon.beans.StudentAndPracticeViewModel;
import com.netcracker.pmbackend.impl.entities.AssignStudentsEntity;
import com.netcracker.pmbackend.impl.entities.SpecialityEntity;
import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import org.springframework.core.convert.converter.Converter;


public class StudentEntityToStudentAndPracticeConverter implements Converter<StudentsEntity, StudentAndPracticeViewModel> {

    @Override
    public StudentAndPracticeViewModel convert(StudentsEntity studentsEntity) {
        StudentAndPracticeViewModel studentAndPracticeViewModel = new StudentAndPracticeViewModel();
        String studentId = String.valueOf(studentsEntity.getId());
        studentAndPracticeViewModel.setId(studentId);
        studentAndPracticeViewModel.setState(studentId);
        studentAndPracticeViewModel.setName(studentsEntity.getName());
        studentAndPracticeViewModel.setSurname(studentsEntity.getSurname());
        studentAndPracticeViewModel.setAvrMark(String.valueOf(studentsEntity.getAvrMark()));
        studentAndPracticeViewModel.setBudget(studentsEntity.getBudget());
        studentAndPracticeViewModel.setStatus(studentsEntity.getStatus());
        SpecialityEntity specialityEntity = studentsEntity.getSpecialityBySpecialityId();
        studentAndPracticeViewModel.setSpeciality(specialityEntity.getName());
        studentAndPracticeViewModel.setFaculty(specialityEntity.getFacultyByFacultyId().getName());

        for(AssignStudentsEntity a : studentsEntity.getAssignstudentsesById()) {
            studentAndPracticeViewModel.setCompany(a.getPracticesByPracticeId().getCompany());
            studentAndPracticeViewModel.setPracticePeriod(String.valueOf(a.getPracticesByPracticeId().getFirstDate()) +" - "+String.valueOf(a.getPracticesByPracticeId().getFinishDate()));
        }
        return studentAndPracticeViewModel;
    }
}
