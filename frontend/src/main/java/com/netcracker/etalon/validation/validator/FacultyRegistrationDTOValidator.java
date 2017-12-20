package com.netcracker.etalon.validation.validator;

import com.netcracker.etalon.dto.FacultyRegistrationDTO;
import com.netcracker.etalon.validation.validator.message.ErrorMessage;
import com.netcracker.pmbackend.interfaces.basic.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class FacultyRegistrationDTOValidator implements Validator {


    @Autowired
    private FacultyService facultyService;

    @Override
    public boolean supports(Class<?> aClass) {
        return FacultyRegistrationDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        final String FIELD_NAME = "name";

        FacultyRegistrationDTO facultyRegistrationDTO = (FacultyRegistrationDTO) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_NAME, ErrorMessage.EMPTYFIELD.getMessage());
        if(facultyService.findByName(facultyRegistrationDTO.getName()) != null){
            errors.rejectValue(FIELD_NAME, ErrorMessage.FACULTYEXIST.getMessage());
        }
    }
}
