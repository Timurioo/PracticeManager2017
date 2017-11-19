package com.netcracker.pmbackend.impl.services.assign;

import com.netcracker.pmbackend.impl.entities.AssignStudentsEntity;
import com.netcracker.pmbackend.impl.entities.PracticesEntity;
import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import com.netcracker.pmbackend.impl.factory.EntityFactory;
import com.netcracker.pmbackend.interfaces.AssignStudentsService;
import com.netcracker.pmbackend.interfaces.PracticesService;
import com.netcracker.pmbackend.interfaces.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AssignService {


    @Autowired
    private StudentsService studentsService;

    @Autowired
    private PracticesService practicesService;

    @Autowired
    private AssignStudentsService assignStudentsService;

    @Autowired
    private EntityFactory entityFactory;


    @Transactional
    public void assignStudents(int practiceId, List<Integer> studentsIds){

        PracticesEntity practicesEntity = practicesService.findById(practiceId);
        practicesEntity.setAvailableQuantity(practicesEntity.getAvailableQuantity()-studentsIds.size());
        if(practicesEntity.getAvailableQuantity()==0){
            practicesEntity.setStatus("Filled");
        }
        practicesService.save(practicesEntity);

        for(int studentId : studentsIds){
            StudentsEntity studentsEntity = studentsService.findById(studentId);
            studentsEntity.setStatus("Busy");

            studentsService.save(studentsEntity);

            AssignStudentsEntity assignStudentsEntity  = entityFactory.getAssignStudentEntity(practiceId,studentId);
            assignStudentsEntity.setPracticesByPracticeId(practicesEntity);
            assignStudentsEntity.setStudentsByStudentId(studentsEntity);

            assignStudentsService.save(assignStudentsEntity);
        }
    }

    @Transactional
    public void assignStudent(int practiceId, int studentId){

        PracticesEntity practicesEntity = practicesService.findById(practiceId);
        practicesEntity.setAvailableQuantity(practicesEntity.getAvailableQuantity()-1);
        if(practicesEntity.getAvailableQuantity()==0){
            practicesEntity.setStatus("Filled");
        }
        practicesService.save(practicesEntity);

        StudentsEntity studentsEntity = studentsService.findById(studentId);
        studentsEntity.setStatus("Busy");

        studentsService.save(studentsEntity);

        AssignStudentsEntity assignStudentsEntity  = entityFactory.getAssignStudentEntity(practiceId,studentId);
        assignStudentsEntity.setPracticesByPracticeId(practicesEntity);
        assignStudentsEntity.setStudentsByStudentId(studentsEntity);

        assignStudentsService.save(assignStudentsEntity);
    }
}
