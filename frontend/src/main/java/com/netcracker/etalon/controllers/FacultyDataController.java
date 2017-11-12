package com.netcracker.etalon.controllers;

import com.netcracker.etalon.beans.FacultyViewModel;
import com.netcracker.pmbackend.impl.entities.FacultyEntity;
import com.netcracker.pmbackend.interfaces.FacultyService;
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
public class FacultyDataController {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private ConversionService conversionService;

    // Faculty type descriptors
    private final TypeDescriptor facultyEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyEntity.class));
    private final TypeDescriptor facultyViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyViewModel.class));

    private final TypeDescriptor facultyEntityTypeDescriptor = TypeDescriptor.valueOf(FacultyEntity.class);
    private final TypeDescriptor facultyViewModelTypeDescriptor = TypeDescriptor.valueOf(FacultyViewModel.class);


    @RequestMapping(value = "/faculties", method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyViewModel> getFaculties() {
        List<FacultyEntity> allFacultyEntities = facultyService.findAll();
        return (List<FacultyViewModel>) conversionService.convert(allFacultyEntities,facultyEntityListTypeDescriptor,facultyViewModelListTypeDescriptor);
    }


    @RequestMapping(value = "/faculties/{id}", method = RequestMethod.GET)
    @ResponseBody
    public FacultyViewModel getFacultyById(@PathVariable int id) {
        FacultyEntity facultyEntity = facultyService.findById(id);
        return (FacultyViewModel) conversionService.convert(facultyEntity, facultyEntityTypeDescriptor, facultyViewModelTypeDescriptor);
    }
}
