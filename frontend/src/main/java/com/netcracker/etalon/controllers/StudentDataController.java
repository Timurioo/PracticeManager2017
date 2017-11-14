package com.netcracker.etalon.controllers;

import com.netcracker.pmbackend.impl.services.deletion.DeletionService;
import com.netcracker.pmbackend.interfaces.StudentsService;
import com.netcracker.pmbackend.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class StudentDataController {


    @Autowired
    private DeletionService deletionService;


    @RequestMapping(value = "/students", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public Map<String, String> deleteStudents(@RequestBody List<String> studentsIds) {

        for(String studentId : studentsIds) {
            deletionService.deleteStudent(Integer.parseInt(studentId));
        }
        return null;
    }
}
