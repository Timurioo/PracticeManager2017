package com.netcracker.etalon.controllers;

import com.netcracker.etalon.beans.StudentAndPracticeViewModel;
import com.netcracker.etalon.beans.StudentProfileViewModel;
import com.netcracker.etalon.beans.StudentTableViewModel;
import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import com.netcracker.pmbackend.impl.services.deletion.DeletionService;
import com.netcracker.pmbackend.interfaces.StudentsService;
import com.netcracker.pmbackend.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
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


    private final TypeDescriptor studentAndPracticeViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentAndPracticeViewModel.class));
    private final TypeDescriptor studentEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(StudentsEntity.class));


    @RequestMapping(value = "/students", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public Map<String, String> deleteStudents(@RequestBody List<String> studentsIds) {

        for(String studentId : studentsIds) {
            deletionService.deleteStudent(Integer.parseInt(studentId));
        }
        return null;
    }

    @RequestMapping(value = "/studentsAndPracticeData/curator/{id}", method = RequestMethod.GET)
    @ResponseBody
    public StudentTableViewModel getStudentsAndPractice(@PathVariable int id, @RequestParam( required = false, name = "search") String search, @RequestParam String order, @RequestParam String offset, @RequestParam String limit) {

        List<StudentsEntity> allStudents;
        int totalRows=0;
        if(search != null){
            allStudents = studentsService.findAllByCuratorIdSearchLimit(id,search,Integer.parseInt(limit), Integer.parseInt(offset));
            totalRows = studentsService.findAllByCuratorIdSearch(id,search).size();
        }else{
            allStudents = studentsService.findAllByCuratorIdLimit(id, Integer.parseInt(limit), Integer.parseInt(offset));
            totalRows = studentsService.findAllByCuratorId(id).size();
        }
        StudentTableViewModel studentsTableViewModel = new StudentTableViewModel();
        studentsTableViewModel.setRows((List<StudentAndPracticeViewModel>) conversionService.convert(allStudents,studentEntityTypeDescriptor, studentAndPracticeViewModelTypeDescriptor));
        studentsTableViewModel.setTotal(totalRows);
        return studentsTableViewModel;
    }
}
