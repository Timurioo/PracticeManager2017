package com.netcracker.etalon.controllers;

import com.netcracker.etalon.dto.FacultyRegistrationDTO;
import com.netcracker.etalon.dto.PracticeRegistrationDTO;
import com.netcracker.etalon.validation.converter.ValidationResponseDataConverter;
import com.netcracker.etalon.validation.validator.PracticeRegistrationDTOValidator;
import com.netcracker.pmbackend.impl.entities.FacultyEntity;
import com.netcracker.pmbackend.impl.entities.HeadofpracticesEntity;
import com.netcracker.pmbackend.impl.entities.PracticesEntity;
import com.netcracker.pmbackend.impl.factory.EntityFactory;
import com.netcracker.pmbackend.impl.services.registration.RegistrationService;
import com.netcracker.pmbackend.interfaces.PracticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.DoubleSummaryStatistics;
import java.util.Map;

@Controller
public class PracticeDataController {

    @Autowired
    private PracticesService practicesService;

    @Autowired
    private EntityFactory entityFactory;

    @Autowired
    private PracticeRegistrationDTOValidator practiceRegistrationDTOValidator;

    @Autowired
    private ValidationResponseDataConverter validationResponseDataConverter;

    @Autowired
    private RegistrationService registrationService;


    @RequestMapping(value = "/practices", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, String> registerPractice(@RequestBody PracticeRegistrationDTO practiceRegistrationDTO, BindingResult bindingResult) {

        practiceRegistrationDTOValidator.validate(practiceRegistrationDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            return validationResponseDataConverter.convertFieldErrorsToMap(bindingResult.getFieldErrors());
        }

        PracticesEntity practicesEntity = entityFactory.getPracticeEntity(Integer.parseInt(practiceRegistrationDTO.getHeadOfPracticeId()),
                practiceRegistrationDTO.getCompany(),
                Date.valueOf(practiceRegistrationDTO.getFirstDate()),
                Date.valueOf(practiceRegistrationDTO.getFinishDate()),
                Integer.parseInt(practiceRegistrationDTO.getTotalQuantity()),
                practiceRegistrationDTO.getFacultyId().equals("-")?0:Integer.parseInt(practiceRegistrationDTO.getFacultyId()),
                practiceRegistrationDTO.getSpecialityId().equals("-")?0:Integer.parseInt(practiceRegistrationDTO.getSpecialityId()),
                practiceRegistrationDTO.getAvrMark().equals("")?0: Double.parseDouble(practiceRegistrationDTO.getAvrMark()));


        registrationService.registratePractice(practicesEntity);
        return null;
    }
}
