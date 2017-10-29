package com.netcracker.etalon.controllers;

import com.netcracker.etalon.beans.*;
import com.netcracker.pmbackend.impl.entities.PracticesEntity;
import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import com.netcracker.pmbackend.impl.entities.UsersEntity;
import com.netcracker.pmbackend.interfaces.PracticesService;
import com.netcracker.pmbackend.interfaces.SpecialityService;
import com.netcracker.pmbackend.interfaces.StudentsService;
import com.netcracker.pmbackend.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DataController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private PracticesService practicesService;

    @Autowired
    private ConversionService conversionService;


    // Type Descriptors for custom converters
    private final TypeDescriptor userEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UsersEntity.class));
    private final TypeDescriptor userViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserViewModel.class));

    private final TypeDescriptor studentEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentsEntity.class));

    private final TypeDescriptor practiceEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PracticesEntity.class));
    private final TypeDescriptor practiceViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(PracticeViewModel.class));

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

}
