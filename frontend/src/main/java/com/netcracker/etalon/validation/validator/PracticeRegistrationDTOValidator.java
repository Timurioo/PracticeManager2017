package com.netcracker.etalon.validation.validator;


import com.netcracker.etalon.dto.PracticeRegistrationDTO;
import com.netcracker.pmbackend.interfaces.PracticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PracticeRegistrationDTOValidator implements Validator {

    @Autowired
    private PracticesService practicesService;

    @Override
    public boolean supports(Class<?> aClass) {
        return PracticeRegistrationDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PracticeRegistrationDTO practiceRegistrationDTO = (PracticeRegistrationDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"company","Should be not empty");
        if(practicesService.findByCompany(practiceRegistrationDTO.getCompany()) != null){
            errors.rejectValue("company","Such company has been already registered");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"headOfPracticeId","Should be not empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstDate","Should be not empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"finishDate","Should be not empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"totalQuantity","Should be not empty");
    }
}
