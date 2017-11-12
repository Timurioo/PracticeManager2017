package com.netcracker.etalon.controllers;

import com.netcracker.etalon.beans.FacultyViewModel;
import com.netcracker.etalon.beans.SpecialityViewModel;
import com.netcracker.pmbackend.impl.entities.FacultyEntity;
import com.netcracker.pmbackend.impl.entities.SpecialityEntity;
import com.netcracker.pmbackend.interfaces.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class SpecialityDataController {

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private ConversionService conversionService;

    //Speciality type descriptors
    private final TypeDescriptor specialityEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SpecialityEntity.class));
    private final TypeDescriptor specialityViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SpecialityViewModel.class));

    private final TypeDescriptor specialityEntityTypeDescriptor = TypeDescriptor.valueOf(SpecialityEntity.class);
    private final TypeDescriptor specialityViewModelTypeDescriptor = TypeDescriptor.valueOf(SpecialityViewModel.class);


    @RequestMapping(value = "/specialities", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecialityViewModel> getSpecialities() {
        List<SpecialityEntity> allSpecialitiesEntities = specialityService.findAll();
        return (List<SpecialityViewModel>) conversionService.convert(allSpecialitiesEntities,specialityEntityListTypeDescriptor,specialityViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "faculties/{id}/specialities", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecialityViewModel> getSpecialities(@PathVariable int id) {
        List<SpecialityEntity> allSpecialitiesEntities = specialityService.findByFacultyId(id);
        return (List<SpecialityViewModel>) conversionService.convert(allSpecialitiesEntities,specialityEntityListTypeDescriptor,specialityViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "/specialities/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SpecialityViewModel getFacultyById(@PathVariable int id) {
        SpecialityEntity specialityEntity = specialityService.findById(id);
        return (SpecialityViewModel) conversionService.convert(specialityEntity, specialityEntityTypeDescriptor, specialityViewModelTypeDescriptor);
    }
}
