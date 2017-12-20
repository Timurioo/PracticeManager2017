package com.netcracker.etalon.controllers;

import com.netcracker.etalon.beans.StudentAndPracticeViewModel;
import com.netcracker.etalon.beans.StudentProfileViewModel;
import com.netcracker.etalon.beans.StudentTableViewModel;
import com.netcracker.etalon.dto.StudentRegistrationDTO;
import com.netcracker.etalon.dto.filter.FullTableFilterDTO;
import com.netcracker.etalon.dto.filter.SimpleTableFilterDTO;
import com.netcracker.etalon.validation.converter.ValidationResponseDataConverter;
import com.netcracker.etalon.validation.validator.StudentRegistrationDTOValidator;
import com.netcracker.pmbackend.impl.entities.StudentTableData;
import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import com.netcracker.pmbackend.impl.entities.UsersEntity;
import com.netcracker.pmbackend.impl.factory.EntityFactory;
import com.netcracker.pmbackend.interfaces.basic.StudentsService;
import com.netcracker.pmbackend.interfaces.deletion.DeletionService;
import com.netcracker.pmbackend.interfaces.registration.RegistrationService;
import com.netcracker.pmbackend.interfaces.table.StudentTableDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/students")
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


    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public Map<String, String> deleteStudents(@RequestBody List<String> studentsIds) {

        for(String studentId : studentsIds) {
            deletionService.deleteStudent(Integer.parseInt(studentId));
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public StudentProfileViewModel getStudentProfileData(@PathVariable int id) {
        StudentsEntity student = studentsService.findById(id);
        return (StudentProfileViewModel) conversionService.convert(student,singleStudentEntityTypeDescriptor, studentProfileViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/practiceData", method = RequestMethod.GET)
    @ResponseBody
    public StudentTableViewModel getStudentsAndPractice(FullTableFilterDTO fullTableFilterDTO) {
        StudentTableData studentTableData = studentTableDataService.getActualTableData(fullTableFilterDTO.getSearch(), fullTableFilterDTO.getFilter(), fullTableFilterDTO.getSort(), fullTableFilterDTO.getOrder(), fullTableFilterDTO.getLimit(), fullTableFilterDTO.getOffset());
        StudentTableViewModel studentsTableViewModel = new StudentTableViewModel();
        studentsTableViewModel.setRows((List<StudentAndPracticeViewModel>) conversionService.convert(studentTableData.getRowsData(),studentEntityListTypeDescriptor, studentAndPracticeViewModelListTypeDescriptor));
        studentsTableViewModel.setTotal(studentTableData.getTotalRows());
        return studentsTableViewModel;
    }

    @RequestMapping(value = "/practiceData/curator/{id}", method = RequestMethod.GET)
    @ResponseBody
    public StudentTableViewModel getStudentsAndPracticeDataByCurator(@PathVariable int id, SimpleTableFilterDTO simpleTableFilterDTO) {

        List<StudentsEntity> allStudents;
        int totalRows;
        if(simpleTableFilterDTO.getSearch() != null){
            allStudents = studentsService.findAllByCuratorIdSearchLimit(id, simpleTableFilterDTO.getSearch(), simpleTableFilterDTO.getLimit(), simpleTableFilterDTO.getOffset());
            totalRows = studentsService.countAllByCuratorIdSearch(id, simpleTableFilterDTO.getSearch());
        }else{
            allStudents = studentsService.findAllByCuratorIdLimit(id, simpleTableFilterDTO.getLimit(), simpleTableFilterDTO.getOffset());
            totalRows = studentsService.countAllByCuratorId(id);
        }
        StudentTableViewModel studentsTableViewModel = new StudentTableViewModel();
        studentsTableViewModel.setRows((List<StudentAndPracticeViewModel>) conversionService.convert(allStudents,studentEntityListTypeDescriptor, studentAndPracticeViewModelListTypeDescriptor));
        studentsTableViewModel.setTotal(totalRows);
        return studentsTableViewModel;
    }
}
