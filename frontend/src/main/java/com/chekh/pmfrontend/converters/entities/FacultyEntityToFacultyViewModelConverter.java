package com.chekh.pmfrontend.converters.entities;

import com.chekh.pmfrontend.beans.FacultyViewModel;
import com.chekh.pmbackend.impl.entities.FacultyEntity;
import org.springframework.core.convert.converter.Converter;


public class FacultyEntityToFacultyViewModelConverter implements Converter<FacultyEntity, FacultyViewModel>{

    public FacultyViewModel convert(FacultyEntity facultyEntity) {

        FacultyViewModel facultyViewModel = new FacultyViewModel();
        facultyViewModel.setId(String.valueOf(facultyEntity.getId()));
        facultyViewModel.setName(facultyEntity.getName());
        return facultyViewModel;
    }
}
