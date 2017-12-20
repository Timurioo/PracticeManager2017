package com.netcracker.etalon.validation.validator;

import com.netcracker.etalon.dto.FacultyRegistrationDTO;
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
    public void validate(Object o, Errors errors) {
        FacultyRegistrationDTO facultyRegistrationDTO = (FacultyRegistrationDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","Should be not empty");
        if(facultyService.findByName(facultyRegistrationDTO.getName()) != null){
            errors.rejectValue("name","Faculty has been already registered");
        }
    }
}
