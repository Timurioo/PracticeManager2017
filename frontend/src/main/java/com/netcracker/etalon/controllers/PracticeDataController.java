package com.netcracker.etalon.controllers;

import com.netcracker.etalon.beans.PracticeTableViewModel;
import com.netcracker.etalon.beans.PracticeViewModel;
import com.netcracker.etalon.dto.FacultyRegistrationDTO;
import com.netcracker.etalon.dto.PracticeRegistrationDTO;
import com.netcracker.etalon.validation.converter.ValidationResponseDataConverter;
import com.netcracker.etalon.validation.validator.PracticeRegistrationDTOValidator;
import com.netcracker.pmbackend.impl.entities.FacultyEntity;
import com.netcracker.pmbackend.impl.entities.HeadofpracticesEntity;
import com.netcracker.pmbackend.impl.entities.PracticesEntity;
import com.netcracker.pmbackend.impl.factory.EntityFactory;
import com.netcracker.pmbackend.impl.services.deletion.DeletionService;
import com.netcracker.pmbackend.impl.services.registration.RegistrationService;
import com.netcracker.pmbackend.interfaces.PracticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.DoubleSummaryStatistics;
import java.util.List;
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

    @Autowired
    private DeletionService deletionService;

    @Autowired
    private ConversionService conversionService;

    // Practice type descriptors
    private final TypeDescriptor practiceEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PracticesEntity.class));
    private final TypeDescriptor practiceViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PracticeViewModel.class));

    private final TypeDescriptor practiceEntityTypeDescriptor = TypeDescriptor.valueOf(PracticesEntity.class);
    private final TypeDescriptor practiceViewModelTypeDescriptor = TypeDescriptor.valueOf(PracticeViewModel.class);


    @RequestMapping(value = "/practices", method = RequestMethod.GET)
    @ResponseBody
    public PracticeTableViewModel getPracticeData(@RequestParam( required = false, name = "search") String search, @RequestParam String order, @RequestParam String offset, @RequestParam String limit) {

        List<PracticesEntity> allPractices;
        int totalRows = 0;
        if (search != null) {
            allPractices = practicesService.findAllLimitSearch(search,Integer.parseInt(limit), Integer.parseInt(offset));
            totalRows = practicesService.findAllSearch(search).size();
        } else {
            allPractices = practicesService.findAllLimit(Integer.parseInt(limit), Integer.parseInt(offset));
            totalRows = practicesService.findAll().size();
        }
        PracticeTableViewModel practiceTableViewModel = new PracticeTableViewModel();
        practiceTableViewModel.setRows((List<PracticeViewModel>) conversionService.convert(allPractices, practiceEntityListTypeDescriptor, practiceViewModelListTypeDescriptor));
        practiceTableViewModel.setTotal(totalRows);
        return practiceTableViewModel;
    }

    @RequestMapping(value = "/practices/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PracticeViewModel getPracticeData(@PathVariable int id) {

        PracticesEntity practicesEntity = practicesService.findById(id);
        PracticeViewModel practiceViewModel = (PracticeViewModel) conversionService.convert(practicesEntity,practiceEntityTypeDescriptor, practiceViewModelTypeDescriptor);
        return practiceViewModel;
    }

    @RequestMapping(value = "/practices", method = RequestMethod.POST, produces = "application/json")
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

    @RequestMapping(value = "/practices", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public Map<String, String> deletePractices(@RequestBody List<String> practicesIds) {

        for(String practiceId : practicesIds) {
            deletionService.deletePractice(Integer.parseInt(practiceId));
        }
        return null;
    }

    @RequestMapping(value = "/practices/available", method = RequestMethod.GET)
    @ResponseBody
    public List<PracticeViewModel> getPracticesRequests() {
        List<PracticesEntity> allPractices = practicesService.findByStatus("Available");
        return (List<PracticeViewModel>) conversionService.convert(allPractices,practiceEntityListTypeDescriptor, practiceViewModelListTypeDescriptor);
    }

    @RequestMapping(value = "/practices/curator/{id}", method = RequestMethod.GET)
    @ResponseBody
    public PracticeTableViewModel getPracticeDataByCurator(@PathVariable int id, @RequestParam(required = false, name = "search") String search, @RequestParam String order, @RequestParam String offset, @RequestParam String limit) {

        List<PracticesEntity> allPractices;
        int totalRows = 0;
        if (search != null) {
            allPractices = practicesService.findAllByCuratorIdSearchLimit(id,search,Integer.parseInt(limit), Integer.parseInt(offset));
            totalRows = practicesService.findAllByCuratorIdSearch(id, search).size();
        } else {
            allPractices = practicesService.findAllByCuratorIdLimit(id, Integer.parseInt(limit), Integer.parseInt(offset));
            totalRows = practicesService.findByCuratorId(id).size();
        }
        PracticeTableViewModel practiceTableViewModel = new PracticeTableViewModel();
        practiceTableViewModel.setRows((List<PracticeViewModel>) conversionService.convert(allPractices, practiceEntityListTypeDescriptor, practiceViewModelListTypeDescriptor));
        practiceTableViewModel.setTotal(totalRows);
        return practiceTableViewModel;
    }

}
