package com.netcracker.etalon.controllers;

import com.netcracker.etalon.beans.SpecialityViewModel;
import com.netcracker.etalon.dto.SpecialityRegistrationDTO;
import com.netcracker.etalon.validation.converter.ValidationResponseDataConverter;
import com.netcracker.etalon.validation.validator.SpecialityRegistrationDTOValidator;
import com.netcracker.pmbackend.impl.entities.SpecialityEntity;
import com.netcracker.pmbackend.impl.factory.EntityFactory;
import com.netcracker.pmbackend.interfaces.basic.SpecialityService;
import com.netcracker.pmbackend.interfaces.registration.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/specialities")
public class SpecialityDataController {

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private SpecialityRegistrationDTOValidator specialityRegistrationDTOValidator;

    @Autowired
    private EntityFactory entityFactory;

    @Autowired
    private ValidationResponseDataConverter validationResponseDataConverter;

    @Autowired
    private RegistrationService registrationService;

    //Speciality type descriptors
    private final TypeDescriptor specialityEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SpecialityEntity.class));
    private final TypeDescriptor specialityViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SpecialityViewModel.class));

    private final TypeDescriptor specialityEntityTypeDescriptor = TypeDescriptor.valueOf(SpecialityEntity.class);
    private final TypeDescriptor specialityViewModelTypeDescriptor = TypeDescriptor.valueOf(SpecialityViewModel.class);


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<SpecialityViewModel> getSpecialities() {
        List<SpecialityEntity> allSpecialitiesEntities = specialityService.findAll();
        return (List<SpecialityViewModel>) conversionService.convert(allSpecialitiesEntities,specialityEntityListTypeDescriptor,specialityViewModelListTypeDescriptor);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, String> registerSpeciality(@RequestBody SpecialityRegistrationDTO specialityRegistrationDTO, BindingResult bindingResult) {

        specialityRegistrationDTOValidator.validate(specialityRegistrationDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            return validationResponseDataConverter.convertFieldErrorsToMap(bindingResult.getFieldErrors());
        }

        SpecialityEntity specialityEntity = entityFactory.getSpecialityEntity(specialityRegistrationDTO.getName(),Integer.parseInt(specialityRegistrationDTO.getFacultyId()));

        registrationService.registrateSpeciality(specialityEntity);
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public SpecialityViewModel getSpecialityById(@PathVariable int id) {
        SpecialityEntity specialityEntity = specialityService.findById(id);
        return (SpecialityViewModel) conversionService.convert(specialityEntity, specialityEntityTypeDescriptor, specialityViewModelTypeDescriptor);
    }
}
