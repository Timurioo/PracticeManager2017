package com.netcracker.etalon.validation.validator;

import com.netcracker.etalon.dto.StudentRegistrationDTO;
import com.netcracker.etalon.validation.validator.message.ErrorMessage;
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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"login", ErrorMessage.EMPTYFIELD.getMessage());
        if(usersService.findByLogin(studentRegistrationDTO.getLogin()) != null){
            errors.rejectValue("login", ErrorMessage.LOGININUSE.getMessage());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", ErrorMessage.EMPTYFIELD.getMessage());
        if(usersService.findByPassword(studentRegistrationDTO.getPassword()) != null){
            errors.rejectValue("password", ErrorMessage.PASSWORDINUSE.getMessage());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", ErrorMessage.EMPTYFIELD.getMessage());
        if(studentsService.findByEmail(studentRegistrationDTO.getEmail()) != null){
            errors.rejectValue("email", ErrorMessage.EMAILINUSE.getMessage());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phone", ErrorMessage.EMPTYFIELD.getMessage());
        if(studentsService.findByPhone(studentRegistrationDTO.getPhone()) != null){
            errors.rejectValue("phone", ErrorMessage.PHONEINUSE.getMessage());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"surname", ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"group", ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"budget", ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"avrMark", ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"role", ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"facultyId", ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"specialityId", ErrorMessage.EMPTYFIELD.getMessage());
    }
}
