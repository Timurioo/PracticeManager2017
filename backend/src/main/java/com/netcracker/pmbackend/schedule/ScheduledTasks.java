package com.netcracker.pmbackend.schedule;

import com.netcracker.pmbackend.impl.entities.AssignStudentsEntity;
import com.netcracker.pmbackend.impl.entities.PracticesEntity;
import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import com.netcracker.pmbackend.interfaces.basic.AssignStudentsService;
import com.netcracker.pmbackend.interfaces.basic.PracticesService;
import com.netcracker.pmbackend.interfaces.basic.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
public class ScheduledTasks {

    @Autowired
    private AssignStudentsService assignStudentsService;

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private PracticesService practicesService;

    @Scheduled(cron = "0 0 0 * * *", zone="Europe/Minsk")
    public void checkStudentStatus() {

        List<AssignStudentsEntity> assignStudentsEntityList = assignStudentsService.findAll();

        for (AssignStudentsEntity assignStudentsEntity: assignStudentsEntityList){

            PracticesEntity practicesEntity = practicesService.findById(assignStudentsEntity.getPracticeId());
            Date startDate = practicesEntity.getFirstDate();
            Date finishDate = practicesEntity.getFinishDate();
            Date currentDate = new Date();
            if(currentDate.compareTo(startDate)<0){
                updateStudentStatus(assignStudentsEntity.getStudentId(), "Waiting");
            }else if(currentDate.compareTo(startDate)>=0 && currentDate.compareTo(finishDate)<=0){
                updateStudentStatus(assignStudentsEntity.getStudentId(), "Busy");
            }else{
                updateStudentStatus(assignStudentsEntity.getStudentId(), "Passed");
            }
        }
    }

    private void updateStudentStatus(int studentId, String status){
        StudentsEntity studentsEntity = studentsService.findById(studentId);
        studentsEntity.setStatus(status);
        studentsService.save(studentsEntity);
    }
}
