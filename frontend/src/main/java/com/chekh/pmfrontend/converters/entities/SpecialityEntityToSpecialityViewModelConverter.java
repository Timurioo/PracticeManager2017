package com.chekh.pmfrontend.converters.entities;

import com.chekh.pmfrontend.beans.SpecialityViewModel;
import com.chekh.pmbackend.impl.entities.SpecialityEntity;
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
