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
    public void validate(Object object, Errors errors) {

        final String FIELD_LOGIN = "login";
        final String FIELD_PASSWORD = "password";
        final String FIELD_NAME = "name";
        final String FIELD_ROLE = "role";
        final String FIELD_EMAIL = "email";
        final String FIELD_PHONE = "phone";
        final String FIELD_SURNAME = "surname";
        final String FIELD_CLASS_GROUP = "group";
        final String FIELD_BUDGET = "budget";
        final String FIELD_AVR_MARK = "avrMark";
        final String FIELD_FACULTY_ID = "facultyId";
        final String FIELD_SPECIALITY_ID = "specialityId";

        StudentRegistrationDTO studentRegistrationDTO = (StudentRegistrationDTO) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_LOGIN, ErrorMessage.EMPTYFIELD.getMessage());
        if(usersService.findByLogin(studentRegistrationDTO.getLogin()) != null){
            errors.rejectValue(FIELD_LOGIN, ErrorMessage.LOGININUSE.getMessage());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_PASSWORD, ErrorMessage.EMPTYFIELD.getMessage());
        if(usersService.findByPassword(studentRegistrationDTO.getPassword()) != null){
            errors.rejectValue(FIELD_PASSWORD, ErrorMessage.PASSWORDINUSE.getMessage());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_EMAIL, ErrorMessage.EMPTYFIELD.getMessage());
        if(studentsService.findByEmail(studentRegistrationDTO.getEmail()) != null){
            errors.rejectValue(FIELD_EMAIL, ErrorMessage.EMAILINUSE.getMessage());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_PHONE, ErrorMessage.EMPTYFIELD.getMessage());
        if(studentsService.findByPhone(studentRegistrationDTO.getPhone()) != null){
            errors.rejectValue(FIELD_PHONE, ErrorMessage.PHONEINUSE.getMessage());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_NAME, ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_SURNAME, ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_CLASS_GROUP, ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_BUDGET, ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_AVR_MARK, ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_ROLE, ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_FACULTY_ID, ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_SPECIALITY_ID, ErrorMessage.EMPTYFIELD.getMessage());
    }
}
