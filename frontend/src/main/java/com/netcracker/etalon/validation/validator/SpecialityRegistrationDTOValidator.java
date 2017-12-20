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
    public void validate(Object o, Errors errors) {
        SpecialityRegistrationDTO specialityRegistrationDTO = (SpecialityRegistrationDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", ErrorMessage.EMPTYFIELD.getMessage());
        if(specialityService.findByName(specialityRegistrationDTO.getName()) != null){
            errors.rejectValue("name",ErrorMessage.SPECIALITYEXIST.getMessage());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"facultyId", ErrorMessage.EMPTYFIELD.getMessage());
    }
}
