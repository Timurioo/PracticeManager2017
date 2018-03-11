package com.chekh.pmfrontend.controllers;

import com.chekh.pmfrontend.beans.FacultyViewModel;
import com.chekh.pmfrontend.beans.SpecialityViewModel;
import com.chekh.pmfrontend.dto.FacultyRegistrationDTO;
import com.chekh.pmfrontend.validation.converter.ValidationResponseDataConverter;
import com.chekh.pmfrontend.validation.validator.FacultyRegistrationDTOValidator;
import com.chekh.pmbackend.impl.entities.FacultyEntity;
import com.chekh.pmbackend.impl.entities.SpecialityEntity;
import com.chekh.pmbackend.impl.factory.EntityFactory;
import com.chekh.pmbackend.interfaces.basic.FacultyService;
import com.chekh.pmbackend.interfaces.basic.SpecialityService;
import com.chekh.pmbackend.interfaces.registration.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/faculties")
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

    @Autowired
    private SpecialityService specialityService;

    // Faculty type descriptors
    private final TypeDescriptor facultyEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyEntity.class));
    private final TypeDescriptor facultyViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyViewModel.class));

    private final TypeDescriptor facultyEntityTypeDescriptor = TypeDescriptor.valueOf(FacultyEntity.class);
    private final TypeDescriptor facultyViewModelTypeDescriptor = TypeDescriptor.valueOf(FacultyViewModel.class);

    //Speciality type descriptors
    private final TypeDescriptor specialityEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SpecialityEntity.class));
    private final TypeDescriptor specialityViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SpecialityViewModel.class));


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<FacultyViewModel> getFaculties() {
        List<FacultyEntity> allFacultyEntities = facultyService.findAll();
        return (List<FacultyViewModel>) conversionService.convert(allFacultyEntities,facultyEntityListTypeDescriptor,facultyViewModelListTypeDescriptor);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public FacultyViewModel getFacultyById(@PathVariable int id) {
        FacultyEntity facultyEntity = facultyService.findById(id);
        return (FacultyViewModel) conversionService.convert(facultyEntity, facultyEntityTypeDescriptor, facultyViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/{id}/specialities", method = RequestMethod.GET)
    @ResponseBody
    public List<SpecialityViewModel> getSpecialities(@PathVariable int id) {
        List<SpecialityEntity> allSpecialitiesEntities = specialityService.findByFacultyId(id);
        return (List<SpecialityViewModel>) conversionService.convert(allSpecialitiesEntities,specialityEntityListTypeDescriptor,specialityViewModelListTypeDescriptor);
    }
}
