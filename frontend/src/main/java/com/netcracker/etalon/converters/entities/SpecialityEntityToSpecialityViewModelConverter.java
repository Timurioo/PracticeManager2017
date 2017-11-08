package com.netcracker.etalon.converters.entities;

import com.netcracker.etalon.beans.FacultyViewModel;
import com.netcracker.etalon.beans.SpecialityViewModel;
import com.netcracker.pmbackend.impl.entities.SpecialityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;


public class SpecialityEntityToSpecialityViewModelConverter implements Converter<SpecialityEntity, SpecialityViewModel> {

    @Autowired
    private ConversionService conversionService;

    public SpecialityViewModel convert(SpecialityEntity specialityEntity) {
        SpecialityViewModel specialityViewModel = new SpecialityViewModel();
        specialityViewModel.setId(String.valueOf(specialityEntity.getId()));
        specialityViewModel.setName(specialityEntity.getName());
        specialityViewModel.setFaculty(specialityEntity.getFacultyByFacultyId().getName());
        return specialityViewModel;
    }
}
