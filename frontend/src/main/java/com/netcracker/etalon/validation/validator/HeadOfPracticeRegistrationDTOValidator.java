package com.netcracker.etalon.validation.validator;

import com.netcracker.etalon.dto.HeadOfPracticeRegistrationDTO;
import com.netcracker.etalon.validation.validator.message.ErrorMessage;
import com.netcracker.pmbackend.interfaces.basic.HeadofpracticesService;
import com.netcracker.pmbackend.interfaces.basic.UsersService;
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
        HeadOfPracticeRegistrationDTO headOfPracticeRegistrationDTO = (HeadOfPracticeRegistrationDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"login", ErrorMessage.EMPTYFIELD.getMessage());
        if(usersService.findByLogin(headOfPracticeRegistrationDTO.getLogin()) != null){
            errors.rejectValue("login", ErrorMessage.LOGININUSE.getMessage());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", ErrorMessage.EMPTYFIELD.getMessage());
        if(usersService.findByPassword(headOfPracticeRegistrationDTO.getPassword()) != null){
            errors.rejectValue("password", ErrorMessage.PASSWORDINUSE.getMessage());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", ErrorMessage.EMPTYFIELD.getMessage());
        if(headofpracticesService.findByName(headOfPracticeRegistrationDTO.getName()) != null){
            errors.rejectValue("name",ErrorMessage.NAMEINUSE.getMessage());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"role", ErrorMessage.EMPTYFIELD.getMessage());

    }
}
