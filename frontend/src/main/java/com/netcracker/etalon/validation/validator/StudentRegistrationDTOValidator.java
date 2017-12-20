package com.netcracker.etalon.validation.validator;

import com.netcracker.etalon.dto.StudentRegistrationDTO;
import com.netcracker.pmbackend.interfaces.basic.StudentsService;
import com.netcracker.pmbackend.interfaces.basic.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by dima on 11/8/2017.
 */
@Component
public class StudentRegistrationDTOValidator implements Validator {

    @Autowired
    private UsersService usersService;

    @Autowired
    private StudentsService studentsService;

    @Override
    public boolean supports(Class<?> aClass) {
        return StudentRegistrationDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        StudentRegistrationDTO studentRegistrationDTO = (StudentRegistrationDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"login","Should be not empty");
        if(usersService.findByLogin(studentRegistrationDTO.getLogin()) != null){
            errors.rejectValue("login","Login has been already in use");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","Should be not empty");
        if(usersService.findByPassword(studentRegistrationDTO.getPassword()) != null){
            errors.rejectValue("password","Password has been already in use");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","Should be not empty");
        if(studentsService.findByEmail(studentRegistrationDTO.getEmail()) != null){
            errors.rejectValue("email","Email has been already in use");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phone","Should be not empty");
        if(studentsService.findByPhone(studentRegistrationDTO.getPhone()) != null){
            errors.rejectValue("phone","Phone has been already in use");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","Should be not empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"surname","Should be not empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"group","Should be not empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"budget","Should be not empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"avrMark","Should be not empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"role","Should be not empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"facultyId","Should be not empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"specialityId","Should be not empty");
    }
}
