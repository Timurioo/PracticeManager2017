package com.netcracker.etalon.controllers;


import com.netcracker.etalon.beans.HeadOfPracticeViewModel;
import com.netcracker.etalon.dto.HeadOfPracticeRegistrationDTO;
import com.netcracker.etalon.validation.converter.ValidationResponseDataConverter;
import com.netcracker.etalon.validation.validator.HeadOfPracticeRegistrationDTOValidator;
import com.netcracker.pmbackend.impl.entities.HeadofpracticesEntity;
import com.netcracker.pmbackend.impl.entities.UsersEntity;
import com.netcracker.pmbackend.impl.factory.EntityFactory;
import com.netcracker.pmbackend.interfaces.basic.HeadofpracticesService;
import com.netcracker.pmbackend.interfaces.registration.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
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


    @RequestMapping(value = "/headOfPractice", method = RequestMethod.GET)
    @ResponseBody
    public List<HeadOfPracticeViewModel> getHeadOfPractice() {
        List<HeadofpracticesEntity> allHeadsOfPractice = headofpracticesService.findAll();
        return (List<HeadOfPracticeViewModel>) conversionService.convert(allHeadsOfPractice,headOfPracticeEntityListTypeDescriptor,headOfPracticeViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "/headOfPractice", method = RequestMethod.POST, produces = "application/json")
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
}
