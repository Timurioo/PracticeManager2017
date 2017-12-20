package com.netcracker.etalon.validation.validator;

import com.netcracker.etalon.dto.SpecialityRegistrationDTO;
import com.netcracker.etalon.validation.validator.message.ErrorMessage;
import com.netcracker.pmbackend.interfaces.basic.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class SpecialityRegistrationDTOValidator implements Validator {

    @Autowired
    private SpecialityService specialityService;

    @Override
    public boolean supports(Class<?> aClass) {
        return SpecialityRegistrationDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object object, Errors errors) {

        final String FIELD_NAME = "name";
        final String FIELD_FACULTY_ID = "facultyId";

        SpecialityRegistrationDTO specialityRegistrationDTO = (SpecialityRegistrationDTO) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_NAME, ErrorMessage.EMPTYFIELD.getMessage());
        if(specialityService.findByName(specialityRegistrationDTO.getName()) != null){
            errors.rejectValue(FIELD_NAME, ErrorMessage.SPECIALITYEXIST.getMessage());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_FACULTY_ID, ErrorMessage.EMPTYFIELD.getMessage());
    }
}
