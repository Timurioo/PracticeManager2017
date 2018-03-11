package com.chekh.pmfrontend.controllers;

import com.chekh.pmfrontend.beans.PracticeTableViewModel;
import com.chekh.pmfrontend.beans.PracticeViewModel;
import com.chekh.pmfrontend.dto.filter.SimpleTableFilterDTO;
import com.chekh.pmfrontend.dto.PracticeRegistrationDTO;
import com.chekh.pmfrontend.validation.converter.ValidationResponseDataConverter;
import com.chekh.pmfrontend.validation.validator.PracticeRegistrationDTOValidator;
import com.chekh.pmbackend.impl.entities.PracticesEntity;
import com.chekh.pmbackend.impl.factory.EntityFactory;
import com.chekh.pmbackend.interfaces.basic.PracticesService;
import com.chekh.pmbackend.interfaces.deletion.DeletionService;
import com.chekh.pmbackend.interfaces.registration.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/practices")
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

    @Autowired
    private DeletionService deletionService;

    @Autowired
    private ConversionService conversionService;

    // Practice type descriptors
    private final TypeDescriptor practiceEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PracticesEntity.class));
    private final TypeDescriptor practiceViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PracticeViewModel.class));

    private final TypeDescriptor practiceEntityTypeDescriptor = TypeDescriptor.valueOf(PracticesEntity.class);
    private final TypeDescriptor practiceViewModelTypeDescriptor = TypeDescriptor.valueOf(PracticeViewModel.class);


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public PracticeTableViewModel getPracticeData(SimpleTableFilterDTO simpleTableFilterDTO) {

        List<PracticesEntity> allPractices;
        int totalRows = 0;
        if (simpleTableFilterDTO.getSearch() != null) {
            allPractices = practicesService.findAllLimitSearch(simpleTableFilterDTO.getSearch(), simpleTableFilterDTO.getLimit(), simpleTableFilterDTO.getOffset());
            totalRows = practicesService.findAllSearch(simpleTableFilterDTO.getSearch()).size();
        } else {
            allPractices = practicesService.findAllLimit(simpleTableFilterDTO.getLimit(), simpleTableFilterDTO.getOffset());
            totalRows = practicesService.findAll().size();
        }
        PracticeTableViewModel practiceTableViewModel = new PracticeTableViewModel();
        practiceTableViewModel.setRows((List<PracticeViewModel>) conversionService.convert(allPractices, practiceEntityListTypeDescriptor, practiceViewModelListTypeDescriptor));
        practiceTableViewModel.setTotal(totalRows);
        return practiceTableViewModel;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PracticeViewModel getPracticeData(@PathVariable int id) {

        PracticesEntity practicesEntity = practicesService.findById(id);
        PracticeViewModel practiceViewModel = (PracticeViewModel) conversionService.convert(practicesEntity,practiceEntityTypeDescriptor, practiceViewModelTypeDescriptor);
        return practiceViewModel;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, String> registerPractice(@RequestBody PracticeRegistrationDTO practiceRegistrationDTO, BindingResult bindingResult) {

        practiceRegistrationDTOValidator.validate(practiceRegistrationDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            return validationResponseDataConverter.convertFieldErrorsToMap(bindingResult.getFieldErrors());
        }

        int zeroId = 0;
        PracticesEntity practicesEntity = entityFactory.getPracticeEntity(Integer.parseInt(practiceRegistrationDTO.getHeadOfPracticeId()),
                practiceRegistrationDTO.getCompany(),
                Date.valueOf(practiceRegistrationDTO.getFirstDate()),
                Date.valueOf(practiceRegistrationDTO.getFinishDate()),
                Integer.parseInt(practiceRegistrationDTO.getTotalQuantity()),
                practiceRegistrationDTO.getFacultyId().equals("-")?zeroId:Integer.parseInt(practiceRegistrationDTO.getFacultyId()),
                practiceRegistrationDTO.getSpecialityId().equals("-")?zeroId:Integer.parseInt(practiceRegistrationDTO.getSpecialityId()),
                practiceRegistrationDTO.getAvrMark().equals("")?zeroId: Double.parseDouble(practiceRegistrationDTO.getAvrMark()));

        registrationService.registratePractice(practicesEntity);
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public Map<String, String> deletePractices(@RequestBody List<String> practicesIds) {

        for(String practiceId : practicesIds) {
            deletionService.deletePractice(Integer.parseInt(practiceId));
        }
        return null;
    }

    @RequestMapping(value = "/available", method = RequestMethod.GET)
    @ResponseBody
    public List<PracticeViewModel> getPracticesRequests() {
        List<PracticesEntity> allPractices = practicesService.findByStatus("Available");
        return (List<PracticeViewModel>) conversionService.convert(allPractices,practiceEntityListTypeDescriptor, practiceViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "/curator/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PracticeTableViewModel getPracticeDataByCurator(@PathVariable int id, SimpleTableFilterDTO simpleTableFilterDTO) {
        List<PracticesEntity> allPractices;
        int totalRows = 0;
        if (simpleTableFilterDTO.getSearch() != null) {
            allPractices = practicesService.findAllByCuratorIdSearchLimit(id, simpleTableFilterDTO.getSearch(), simpleTableFilterDTO.getLimit(), simpleTableFilterDTO.getOffset());
            totalRows = practicesService.findAllByCuratorIdSearch(id, simpleTableFilterDTO.getSearch()).size();
        } else {
            allPractices = practicesService.findAllByCuratorIdLimit(id, simpleTableFilterDTO.getLimit(), simpleTableFilterDTO.getOffset());
            totalRows = practicesService.findByCuratorId(id).size();
        }
        PracticeTableViewModel practiceTableViewModel = new PracticeTableViewModel();
        practiceTableViewModel.setRows((List<PracticeViewModel>) conversionService.convert(allPractices, practiceEntityListTypeDescriptor, practiceViewModelListTypeDescriptor));
        practiceTableViewModel.setTotal(totalRows);
        return practiceTableViewModel;
    }
}
