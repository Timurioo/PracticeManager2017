package com.chekh.pmbackend.impl.services.deletion;

import com.chekh.pmbackend.impl.entities.AssignStudentsEntity;
import com.chekh.pmbackend.impl.entities.PracticesEntity;
import com.chekh.pmbackend.impl.entities.StudentsEntity;
import com.chekh.pmbackend.interfaces.basic.AssignStudentsService;
import com.chekh.pmbackend.interfaces.basic.PracticesService;
import com.chekh.pmbackend.interfaces.basic.UsersService;
import com.chekh.pmbackend.interfaces.basic.StudentsService;
import com.chekh.pmbackend.interfaces.deletion.DeletionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeletionServiceImpl implements DeletionService {

    @Autowired
    private UsersService usersService;

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private PracticesService practicesService;

    @Autowired
    private AssignStudentsService assignStudentsService;

    @Transactional
    public void deleteStudent(int id){
        StudentsEntity studentsEntity = studentsService.findById(id);
        List<AssignStudentsEntity> assignStudentsEntityList = assignStudentsService.findByStudentId(id);
        for(AssignStudentsEntity assignStudentsEntity : assignStudentsEntityList) {
            PracticesEntity practicesEntity = practicesService.findById(assignStudentsEntity.getPracticeId());
            practicesEntity.setAvailableQuantity(practicesEntity.getAvailableQuantity() + 1);
            practicesService.save(practicesEntity);
        }
        usersService.delete(studentsEntity.getUserId());
    }

    @Transactional
    public void deletePractice(int id){
        List<AssignStudentsEntity> assignStudentsEntityList = assignStudentsService.findByPracticeId(id);
        for(AssignStudentsEntity assignStudentsEntity : assignStudentsEntityList){
            StudentsEntity studentsEntity = studentsService.findById(assignStudentsEntity.getStudentId());
            studentsEntity.setStatus("Available");
            studentsService.save(studentsEntity);
        }
        practicesService.delete(id);
    }

    @Transactional
    public void deleteAssignStudent(int studentId){
        List<AssignStudentsEntity> assignStudentsEntityList = assignStudentsService.findByStudentId(studentId);

        StudentsEntity studentsEntity = studentsService.findById(studentId);
        studentsEntity.setStatus("Available");
        studentsService.save(studentsEntity);

        for(AssignStudentsEntity assignStudentsEntity : assignStudentsEntityList){
            PracticesEntity practicesEntity = practicesService.findById(assignStudentsEntity.getPracticeId());
            practicesEntity.setAvailableQuantity(practicesEntity.getAvailableQuantity()+1);
            practicesEntity.setStatus("Available");
            practicesService.save(practicesEntity);
            assignStudentsService.delete(assignStudentsEntity.getId());
        }
    }
}
