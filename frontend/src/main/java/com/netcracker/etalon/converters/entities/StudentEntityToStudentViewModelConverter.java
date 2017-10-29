package com.netcracker.etalon.converters.entities;


import com.netcracker.etalon.beans.SpecialityViewModel;
import com.netcracker.etalon.beans.StudentViewModel;
import com.netcracker.etalon.beans.UserViewModel;
import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

public class StudentEntityToStudentViewModelConverter implements Converter<StudentsEntity, StudentViewModel> {

    @Autowired
    private ConversionService conversionService;

    public StudentViewModel convert(StudentsEntity studentsEntity) {
        StudentViewModel studentViewModel = new StudentViewModel();
        studentViewModel.setId(String.valueOf(studentsEntity.getId()));
        studentViewModel.setName(studentsEntity.getName());
        studentViewModel.setSurname(studentsEntity.getSurname());
        studentViewModel.setPhone(studentsEntity.getPhone());
        studentViewModel.setEmail(studentsEntity.getEmail());
        studentViewModel.setGroup(studentsEntity.getGroup());
        studentViewModel.setAvrMark(String.valueOf(studentsEntity.getAvrMark()));
        studentViewModel.setBudget(studentsEntity.getBudget());
        studentViewModel.setStatus(studentsEntity.getStatus());

        studentViewModel.setUserViewModel(conversionService.convert(studentsEntity.getUsersByUserId(), UserViewModel.class));
        studentViewModel.setSpecialityViewModel(conversionService.convert(studentsEntity.getSpecialityBySpecialityId(), SpecialityViewModel.class));
        return studentViewModel;
    }
}
