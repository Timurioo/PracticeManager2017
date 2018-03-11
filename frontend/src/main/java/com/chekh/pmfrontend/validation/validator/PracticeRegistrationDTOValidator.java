package com.chekh.pmfrontend.validation.validator;


import com.chekh.pmfrontend.dto.PracticeRegistrationDTO;
import com.chekh.pmfrontend.validation.validator.message.ErrorMessage;
import com.chekh.pmbackend.interfaces.basic.PracticesService;
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
    public void validate(Object object, Errors errors) {

        final String FIELD_COMPANY = "company";
        final String FIELD_HEAD_OF_PRACTICE_ID = "headOfPracticeId";
        final String FIELD_FIRST_DATE = "firstDate";
        final String FIELD_FINISH_DATE = "finishDate";
        final String FIELD_TOTAL_QUANTITY = "totalQuantity";

        PracticeRegistrationDTO practiceRegistrationDTO = (PracticeRegistrationDTO) object;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_COMPANY, ErrorMessage.EMPTYFIELD.getMessage());
        if(practicesService.findByCompany(practiceRegistrationDTO.getCompany()) != null){
            errors.rejectValue(FIELD_COMPANY, ErrorMessage.COMPANYEXIST.getMessage());
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_HEAD_OF_PRACTICE_ID, ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_FIRST_DATE, ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_FINISH_DATE, ErrorMessage.EMPTYFIELD.getMessage());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, FIELD_TOTAL_QUANTITY,ErrorMessage.EMPTYFIELD.getMessage());
    }
}
