package com.netcracker.etalon.security.validator;

import com.netcracker.etalon.dto.HeadOfPracticeRegistrationDTO;
import com.netcracker.pmbackend.impl.entities.UsersEntity;
import com.netcracker.pmbackend.interfaces.HeadofpracticesService;
import com.netcracker.pmbackend.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by dima on 11/7/2017.
 */
@Component
public class HeadOfPracticeRegistrationDTOValidator implements Validator {

    @Autowired
    private UsersService usersService;

    @Autowired
    private HeadofpracticesService headofpracticesService;

    @Override
    public boolean supports(Class<?> aClass) {
        return HeadOfPracticeRegistrationDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        HeadOfPracticeRegistrationDTO headOfPracticeRegistrationDTO = (HeadOfPracticeRegistrationDTO)o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"login","Should be not empty");
        if(usersService.findByLogin(headOfPracticeRegistrationDTO.getLogin()) != null){
            errors.rejectValue("login","Login has been already in use");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","Should be not empty");
        if(usersService.findByPassword(headOfPracticeRegistrationDTO.getPassword()) != null){
            errors.rejectValue("password","Password has been already in use");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","Should be not empty");
        if(headofpracticesService.findByName(headOfPracticeRegistrationDTO.getName()) != null){
            errors.rejectValue("name","Name has been already in use");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"role","NotEmpty");

    }
}
