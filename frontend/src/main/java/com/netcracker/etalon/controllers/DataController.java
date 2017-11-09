package com.netcracker.etalon.controllers;

import com.netcracker.etalon.beans.*;
import com.netcracker.etalon.dto.HeadOfPracticeRegistrationDTO;
import com.netcracker.etalon.dto.FacultyRegistrationDTO;
import com.netcracker.etalon.dto.StudentRegistrationDTO;
import com.netcracker.etalon.validation.converter.ValidationResponseDataConverter;
import com.netcracker.etalon.validation.validator.HeadOfPracticeRegistrationDTOValidator;
import com.netcracker.etalon.validation.validator.StudentRegistrationDTOValidator;
import com.netcracker.pmbackend.impl.entities.*;
import com.netcracker.pmbackend.impl.factory.EntityFactory;
import com.netcracker.pmbackend.impl.services.registration.RegistrationService;
import com.netcracker.pmbackend.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class DataController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private PracticesService practicesService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private HeadofpracticesService headofpracticesService;

    @Autowired
    private HeadOfPracticeRegistrationDTOValidator headOfPracticeRegistrationDTOValidator;

    @Autowired
    private StudentRegistrationDTOValidator studentRegistrationDTOValidator;

    @Autowired
    private ValidationResponseDataConverter validationResponseDataConverter;

    @Autowired
    private EntityFactory entityFactory;

    @Autowired
    private RegistrationService registrationService;


    // Type Descriptors for custom converters
    private final TypeDescriptor userEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UsersEntity.class));
    private final TypeDescriptor userViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserViewModel.class));

    private final TypeDescriptor studentEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentsEntity.class));

    private final TypeDescriptor practiceEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PracticesEntity.class));
    private final TypeDescriptor practiceViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PracticeViewModel.class));

    // Faculty type descriptors
    private final TypeDescriptor facultyEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyEntity.class));
    private final TypeDescriptor facultyViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FacultyViewModel.class));

    //Speciality type descriptors
    private final TypeDescriptor specialityEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SpecialityEntity.class));
    private final TypeDescriptor specialityViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(SpecialityViewModel.class));


    private final TypeDescriptor studentAndPracticeViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentAndPracticeViewModel.class));
    private final TypeDescriptor studentProfileViewModelTypeDescriptor = TypeDescriptor.valueOf(StudentProfileViewModel.class);
    private final TypeDescriptor singleStudentEntityTypeDescriptor = TypeDescriptor.valueOf(StudentsEntity.class);

    @RequestMapping(value = "/studentsAndPracticeData", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentAndPracticeViewModel> getStudentsAndPractice() {
        List<StudentsEntity> allStudents = studentsService.findAll();
        return (List<StudentAndPracticeViewModel>) conversionService.convert(allStudents,studentEntityTypeDescriptor, studentAndPracticeViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/practicesData", method = RequestMethod.GET)
    @ResponseBody
    public List<PracticeViewModel> getPracticeData() {
        List<PracticesEntity> allPractices = practicesService.findAll();
        return (List<PracticeViewModel>) conversionService.convert(allPractices,practiceEntityTypeDescriptor, practiceViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/studentProfileData", method = RequestMethod.GET)
    @ResponseBody
    public StudentProfileViewModel getStudentProfileData(@RequestParam String id) {
        StudentsEntity student = studentsService.findById(Integer.parseInt(id));
        return (StudentProfileViewModel) conversionService.convert(student,singleStudentEntityTypeDescriptor, studentProfileViewModelTypeDescriptor);
    }


    @RequestMapping(value = "/usersData", method = RequestMethod.GET)
    @ResponseBody
    public List<UserViewModel> getUsersAsJson() {
        List<UsersEntity> allUsers = usersService.findAll();
        return (List<UserViewModel>) conversionService.convert(allUsers,userEntityTypeDescriptor, userViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/headOfPracticeRegistration", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, String> registrationHeadOfPractice(@RequestBody HeadOfPracticeRegistrationDTO headOfPracticeRegistrationDTO, BindingResult bindingResult) {

        headOfPracticeRegistrationDTOValidator.validate(headOfPracticeRegistrationDTO, bindingResult);

        if (bindingResult.hasErrors()) {
            return validationResponseDataConverter.convertFieldErrorsToMap(bindingResult.getFieldErrors());
        }

        UsersEntity usersEntity = entityFactory.getUserEntity(headOfPracticeRegistrationDTO.getLogin(),headOfPracticeRegistrationDTO.getPassword(),headOfPracticeRegistrationDTO.getRole());
        HeadofpracticesEntity headofpracticesEntity = entityFactory.getHeadOfPracticeEntity(headOfPracticeRegistrationDTO.getName());

        registrationService.registrateHeadOfPractice(usersEntity, headofpracticesEntity);

        return null;
    }

    @RequestMapping(value = "/studentRegistration", method = RequestMethod.POST, produces = "application/json")
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

    @RequestMapping(value = "/facultyData", method = RequestMethod.POST)
    @ResponseBody
    public List<FacultyViewModel> getFacultyData() {
        List<FacultyEntity> allFaculties = facultyService.findAll();
        return (List<FacultyViewModel>) conversionService.convert(allFaculties,facultyEntityTypeDescriptor, facultyViewModelTypeDescriptor);
    }

    @RequestMapping(value = "/specialityData", method = RequestMethod.POST)
    @ResponseBody
    public List<SpecialityViewModel> getSpecialityData(@RequestBody FacultyRegistrationDTO facultyRegistrationDTO) {
        List<SpecialityEntity> allSpecialities = specialityService.findByFacultyId(Integer.parseInt(facultyRegistrationDTO.getFacultyId()));
        return (List<SpecialityViewModel>) conversionService.convert(allSpecialities,specialityEntityTypeDescriptor, specialityViewModelTypeDescriptor);
    }


}
