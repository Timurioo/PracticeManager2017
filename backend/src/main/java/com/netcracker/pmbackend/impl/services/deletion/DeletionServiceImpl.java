package com.netcracker.pmbackend.impl.services.deletion;

import com.netcracker.pmbackend.impl.entities.AssignStudentsEntity;
import com.netcracker.pmbackend.impl.entities.PracticesEntity;
import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import com.netcracker.pmbackend.interfaces.basic.AssignStudentsService;
import com.netcracker.pmbackend.interfaces.basic.PracticesService;
import com.netcracker.pmbackend.interfaces.basic.StudentsService;
import com.netcracker.pmbackend.interfaces.basic.UsersService;
import com.netcracker.pmbackend.interfaces.deletion.DeletionService;
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
            practicesService.save(practicesEntity);
            assignStudentsService.delete(assignStudentsEntity.getId());
        }
    }
}
