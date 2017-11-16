package com.netcracker.etalon.controllers;

import com.netcracker.etalon.dto.AssignStudentDTO;
import com.netcracker.pmbackend.impl.services.assign.AssignService;
import org.omg.CORBA.PRIVATE_MEMBER;
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

    @RequestMapping(value = "/assignStudents", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Map<String, String> assignStudents(@RequestBody AssignStudentDTO assignStudentDTO) {

        List<Integer> studentsIds = assignStudentDTO.getStudentsIds().stream().map(Integer::parseInt).collect(Collectors.toList());

        //assignService.assignStudents(Integer.parseInt(assignStudentDTO.getPracticeId()),studentsIds);

        for(int id: studentsIds){
            assignService.assignStudent(Integer.parseInt(assignStudentDTO.getPracticeId()), id);
        }

        return null;
    }

}
