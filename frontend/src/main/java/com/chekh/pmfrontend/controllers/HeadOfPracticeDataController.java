package com.chekh.pmfrontend.controllers;


import com.chekh.pmfrontend.beans.HeadOfPracticeViewModel;
import com.chekh.pmfrontend.dto.HeadOfPracticeRegistrationDTO;
import com.chekh.pmfrontend.validation.converter.ValidationResponseDataConverter;
import com.chekh.pmfrontend.validation.validator.HeadOfPracticeRegistrationDTOValidator;
import com.chekh.pmbackend.impl.entities.HeadofpracticesEntity;
import com.chekh.pmbackend.impl.entities.UsersEntity;
import com.chekh.pmbackend.impl.factory.EntityFactory;
import com.chekh.pmbackend.interfaces.basic.HeadofpracticesService;
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
@RequestMapping("/headOfPractice")
public class HeadOfPracticeDataController {


    @Autowired
    private HeadofpracticesService headofpracticesService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private HeadOfPracticeRegistrationDTOValidator headOfPracticeRegistrationDTOValidator;

    @Autowired
    private EntityFactory entityFactory;

    @Autowired
    private ValidationResponseDataConverter validationResponseDataConverter;

    @Autowired
    private RegistrationService registrationService;

    // HeadOfPractice type descriptors
    private final TypeDescriptor headOfPracticeEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HeadofpracticesEntity.class));
    private final TypeDescriptor headOfPracticeViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HeadOfPracticeViewModel.class));

    private final TypeDescriptor headOfPracticeEntityTypeDescriptor = TypeDescriptor.valueOf(HeadofpracticesEntity.class);
    private final TypeDescriptor headOfPracticeViewModelTypeDescriptor = TypeDescriptor.valueOf(HeadOfPracticeViewModel.class);


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<HeadOfPracticeViewModel> getHeadOfPractice() {
        List<HeadofpracticesEntity> allHeadsOfPractice = headofpracticesService.findAll();
        return (List<HeadOfPracticeViewModel>) conversionService.convert(allHeadsOfPractice,headOfPracticeEntityListTypeDescriptor,headOfPracticeViewModelListTypeDescriptor);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, String> registrationHeadOfPractice(@RequestBody HeadOfPracticeRegistrationDTO headOfPracticeRegistrationDTO, BindingResult bindingResult) {

        headOfPracticeRegistrationDTOValidator.validate(headOfPracticeRegistrationDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            return validationResponseDataConverter.convertFieldErrorsToMap(bindingResult.getFieldErrors());
        }

        UsersEntity usersEntity = entityFactory.getUserEntity(headOfPracticeRegistrationDTO.getLogin(),headOfPracticeRegistrationDTO.getPassword(),headOfPracticeRegistrationDTO.getRole());
        HeadofpracticesEntity headofpracticesEntity = entityFactory.getHeadOfPracticeEntity(headOfPracticeRegistrationDTO.getName());

        registrationService.registrateHeadOfPractice(usersEntity, headofpracticesEntity);

        return null;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public HeadOfPracticeViewModel getHeadOfPracticeName(@PathVariable int id) {
        HeadofpracticesEntity headofpracticesEntity = headofpracticesService.findById(id);
        HeadOfPracticeViewModel headOfPracticeViewModel = (HeadOfPracticeViewModel) conversionService.convert(headofpracticesEntity, headOfPracticeEntityTypeDescriptor, headOfPracticeViewModelTypeDescriptor);
        return headOfPracticeViewModel;
    }
}
