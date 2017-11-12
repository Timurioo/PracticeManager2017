package com.netcracker.etalon.controllers;

import com.netcracker.etalon.beans.FacultyViewModel;
import com.netcracker.etalon.dto.FacultyRegistrationDTO;
import com.netcracker.etalon.validation.converter.ValidationResponseDataConverter;
import com.netcracker.etalon.validation.validator.FacultyRegistrationDTOValidator;
import com.netcracker.pmbackend.impl.entities.FacultyEntity;
import com.netcracker.pmbackend.impl.factory.EntityFactory;
import com.netcracker.pmbackend.impl.services.registration.RegistrationService;
import com.netcracker.pmbackend.interfaces.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
public class FacultyDataController {

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private FacultyRegistrationDTOValidator facultyRegistrationDTOValidator;

    @Autowired
    private ValidationResponseDataConverter validationResponseDataConverter;

    @Autowired
    private EntityFactory entityFactory;

    @Autowired
    private RegistrationService registrationService;

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

    @RequestMapping(value = "/faculties", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, String> registerFaculty(@RequestBody FacultyRegistrationDTO facultyRegistrationDTO, BindingResult bindingResult) {

        facultyRegistrationDTOValidator.validate(facultyRegistrationDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            return validationResponseDataConverter.convertFieldErrorsToMap(bindingResult.getFieldErrors());
        }

        FacultyEntity facultyEntity = entityFactory.getFacultyEntity(facultyRegistrationDTO.getName());

        registrationService.registrateFaculty(facultyEntity);

        return null;
    }

    @RequestMapping(value = "/faculties/{id}", method = RequestMethod.GET)
    @ResponseBody
    public FacultyViewModel getFacultyById(@PathVariable int id) {
        FacultyEntity facultyEntity = facultyService.findById(id);
        return (FacultyViewModel) conversionService.convert(facultyEntity, facultyEntityTypeDescriptor, facultyViewModelTypeDescriptor);
    }
}
