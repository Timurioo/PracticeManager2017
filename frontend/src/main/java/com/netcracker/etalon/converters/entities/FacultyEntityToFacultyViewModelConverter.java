package com.netcracker.etalon.converters.entities;

import com.netcracker.etalon.beans.FacultyViewModel;
import com.netcracker.pmbackend.impl.entities.FacultyEntity;
import org.springframework.core.convert.converter.Converter;


public class FacultyEntityToFacultyViewModelConverter implements Converter<FacultyEntity, FacultyViewModel>{

    public FacultyViewModel convert(FacultyEntity facultyEntity) {

        FacultyViewModel facultyViewModel = new FacultyViewModel();
        facultyViewModel.setId(String.valueOf(facultyEntity.getId()));
        facultyViewModel.setName(facultyEntity.getName());
        return facultyViewModel;
    }
}
