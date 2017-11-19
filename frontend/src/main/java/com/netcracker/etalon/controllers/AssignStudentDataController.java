package com.netcracker.etalon.controllers;

import com.netcracker.etalon.dto.AssignStudentDTO;
import com.netcracker.pmbackend.impl.services.assign.AssignService;
import com.netcracker.pmbackend.impl.services.deletion.DeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class AssignStudentDataController {

    @Autowired
    private AssignService assignService;

    @Autowired
    private DeletionService deletionService;

    @RequestMapping(value = "/assignStudents", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, String> assignStudents(@RequestBody AssignStudentDTO assignStudentDTO) {

        List<Integer> studentsIds = assignStudentDTO.getStudentsIds().stream().map(Integer::parseInt).collect(Collectors.toList());

        assignService.assignStudents(Integer.parseInt(assignStudentDTO.getPracticeId()),studentsIds);
        return null;
    }

    @RequestMapping(value = "/assignStudents", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public Map<String, String> releaseStudents(@RequestBody List<String> studentsIds) {

        for (String studentId : studentsIds){
            deletionService.deleteAssignStudent(Integer.parseInt(studentId));
        }

        return null;
    }

}
