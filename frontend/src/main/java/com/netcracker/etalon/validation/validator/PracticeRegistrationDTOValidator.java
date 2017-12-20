package com.netcracker.etalon.validation.validator;


import com.netcracker.etalon.dto.PracticeRegistrationDTO;
import com.netcracker.etalon.validation.validator.message.ErrorMessage;
import com.netcracker.pmbackend.interfaces.basic.PracticesService;
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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"company", ErrorMessage.EMPTYFIELD.getMessage());
        if(practicesService.findByCompany(practiceRegistrationDTO.getCompany()) != null){
            errors.rejectValue("company", ErrorMessage.COMPANYEXIST.getMessage());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"headOfPracticeId", ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstDate", ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"finishDate", ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"totalQuantity",ErrorMessage.EMPTYFIELD.getMessage());
    }
}
