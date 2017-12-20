package com.netcracker.etalon.controllers;

import com.netcracker.etalon.dto.AssignStudentDTO;
import com.netcracker.pmbackend.interfaces.assign.AssignService;
import com.netcracker.pmbackend.interfaces.deletion.DeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/assignStudents")
public class AssignStudentDataController {

    @Autowired
    private AssignService assignService;

    @Autowired
    private DeletionService deletionService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public void assignStudents(@RequestBody AssignStudentDTO assignStudentDTO) {

        List<Integer> studentsIds = assignStudentDTO.getStudentsIds().stream().map(Integer::parseInt).collect(Collectors.toList());
        assignService.assignStudents(Integer.parseInt(assignStudentDTO.getPracticeId()),studentsIds);
    }

    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public void releaseStudents(@RequestBody List<String> studentsIds) {

        for (String studentId : studentsIds){
            deletionService.deleteAssignStudent(Integer.parseInt(studentId));
        }
    }

}
