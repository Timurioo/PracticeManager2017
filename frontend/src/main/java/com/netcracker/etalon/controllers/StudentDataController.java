package com.netcracker.etalon.controllers;

import com.netcracker.etalon.beans.StudentAndPracticeViewModel;
import com.netcracker.etalon.beans.StudentProfileViewModel;
import com.netcracker.etalon.beans.StudentTableViewModel;
import com.netcracker.etalon.dto.StudentRegistrationDTO;
import com.netcracker.etalon.validation.converter.ValidationResponseDataConverter;
import com.netcracker.etalon.validation.validator.StudentRegistrationDTOValidator;
import com.netcracker.pmbackend.impl.entities.StudentTableData;
import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import com.netcracker.pmbackend.impl.entities.UsersEntity;
import com.netcracker.pmbackend.impl.factory.EntityFactory;
import com.netcracker.pmbackend.impl.services.deletion.DeletionService;
import com.netcracker.pmbackend.impl.services.registration.RegistrationService;
import com.netcracker.pmbackend.impl.services.table.StudentTableDataService;
import com.netcracker.pmbackend.interfaces.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class StudentDataController {

    @Autowired
    private DeletionService deletionService;

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private EntityFactory entityFactory;

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private StudentRegistrationDTOValidator studentRegistrationDTOValidator;

    @Autowired
    private ValidationResponseDataConverter validationResponseDataConverter;

    @Autowired
    private StudentTableDataService studentTableDataService;

    private final TypeDescriptor studentAndPracticeViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentAndPracticeViewModel.class));
    private final TypeDescriptor studentEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentsEntity.class));

    private final TypeDescriptor studentProfileViewModelTypeDescriptor = TypeDescriptor.valueOf(StudentProfileViewModel.class);
    private final TypeDescriptor singleStudentEntityTypeDescriptor = TypeDescriptor.valueOf(StudentsEntity.class);


    @RequestMapping(value = "/students", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public Map<String, String> deleteStudents(@RequestBody List<String> studentsIds) {

        for(String studentId : studentsIds) {
            deletionService.deleteStudent(Integer.parseInt(studentId));
        }
        return null;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, String> registrationStudent(@RequestBody StudentRegistrationDTO studentRegistrationDTO, BindingResult bindingResult) {

        studentRegistrationDTOValidator.validate(studentRegistrationDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            return validationResponseDataConverter.convertFieldErrorsToMap(bindingResult.getFieldErrors());
        }

        UsersEntity usersEntity = entityFactory.getUserEntity(studentRegistrationDTO.getLogin(),studentRegistrationDTO.getPassword(),studentRegistrationDTO.getRole());
        StudentsEntity studentsEntity = entityFactory.getStudentEntity(studentRegistrationDTO.getName(),
                studentRegistrationDTO.getSurname(),
                studentRegistrationDTO.getPhone(),
                studentRegistrationDTO.getEmail(),
                Integer.parseInt(studentRegistrationDTO.getSpecialityId()),
                studentRegistrationDTO.getGroup(),
                Double.parseDouble(studentRegistrationDTO.getAvrMark()),
                studentRegistrationDTO.getBudget());

        registrationService.registrateStudent(usersEntity, studentsEntity);

        return null;
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    @ResponseBody
    public StudentProfileViewModel getStudentProfileData(@PathVariable String id) {
        StudentsEntity student = studentsService.findById(Integer.parseInt(id));
        return (StudentProfileViewModel) conversionService.convert(student,singleStudentEntityTypeDescriptor, studentProfileViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/studentsAndPracticeData", method = RequestMethod.GET)
    @ResponseBody
    public StudentTableViewModel getStudentsAndPractice(@RequestParam(required = false, name = "search", defaultValue = "") String search, @RequestParam(required = false, name = "sort", defaultValue = "") String sort, @RequestParam String order, @RequestParam String offset, @RequestParam String limit, @RequestParam(required = false, name = "filter", defaultValue = "") String filter) {
        StudentTableData studentTableData = studentTableDataService.getActualTableData(search, filter, sort, order, Integer.parseInt(limit), Integer.parseInt(offset));
        StudentTableViewModel studentsTableViewModel = new StudentTableViewModel();
        studentsTableViewModel.setRows((List<StudentAndPracticeViewModel>) conversionService.convert(studentTableData.getRowsData(),studentEntityListTypeDescriptor, studentAndPracticeViewModelListTypeDescriptor));
        studentsTableViewModel.setTotal(studentTableData.getTotalRows());
        return studentsTableViewModel;
    }

    @RequestMapping(value = "/studentsAndPracticeData/curator/{id}", method = RequestMethod.GET)
    @ResponseBody
    public StudentTableViewModel getStudentsAndPractice(@PathVariable int id, @RequestParam( required = false, name = "search") String search, @RequestParam String order, @RequestParam String offset, @RequestParam String limit) {

        List<StudentsEntity> allStudents;
        int totalRows;
        if(search != null){
            allStudents = studentsService.findAllByCuratorIdSearchLimit(id,search,Integer.parseInt(limit), Integer.parseInt(offset));
            totalRows = studentsService.countAllByCuratorIdSearch(id,search);
        }else{
            allStudents = studentsService.findAllByCuratorIdLimit(id, Integer.parseInt(limit), Integer.parseInt(offset));
            totalRows = studentsService.countAllByCuratorId(id);
        }
        StudentTableViewModel studentsTableViewModel = new StudentTableViewModel();
        studentsTableViewModel.setRows((List<StudentAndPracticeViewModel>) conversionService.convert(allStudents,studentEntityListTypeDescriptor, studentAndPracticeViewModelListTypeDescriptor));
        studentsTableViewModel.setTotal(totalRows);
        return studentsTableViewModel;
    }
}
