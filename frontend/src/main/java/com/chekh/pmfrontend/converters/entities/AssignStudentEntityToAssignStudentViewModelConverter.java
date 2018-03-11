package com.chekh.pmfrontend.converters.entities;

import com.chekh.pmfrontend.beans.AssignStudentViewModel;
import com.chekh.pmfrontend.beans.PracticeViewModel;
import com.chekh.pmfrontend.beans.StudentViewModel;
import com.chekh.pmbackend.impl.entities.AssignStudentsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;


public class AssignStudentEntityToAssignStudentViewModelConverter implements Converter<AssignStudentsEntity, AssignStudentViewModel> {

    @Autowired
    private ConversionService conversionService;

    public AssignStudentViewModel convert(AssignStudentsEntity assignstudentsEntity) {
        AssignStudentViewModel assignStudentViewModel = new AssignStudentViewModel();
        assignStudentViewModel.setId(String.valueOf(assignstudentsEntity.getId()));
        assignStudentViewModel.setStudentViewModel(conversionService.convert(assignstudentsEntity.getStudentsByStudentId(), StudentViewModel.class));
        assignStudentViewModel.setPracticeViewModel(conversionService.convert(assignstudentsEntity.getPracticesByPracticeId(), PracticeViewModel.class));
        return assignStudentViewModel;
    }
}
