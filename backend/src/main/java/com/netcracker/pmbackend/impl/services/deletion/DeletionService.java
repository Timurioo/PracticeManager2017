package com.netcracker.pmbackend.impl.services.deletion;

import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import com.netcracker.pmbackend.interfaces.PracticesService;
import com.netcracker.pmbackend.interfaces.StudentsService;
import com.netcracker.pmbackend.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeletionService {

    @Autowired
    private UsersService usersService;

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private PracticesService practicesService;

    @Transactional
    public void deleteStudent(int id){
        StudentsEntity studentsEntity = studentsService.findById(id);
        usersService.delete(studentsEntity.getUserId());
    }

    @Transactional
    public void deletePractice(int id){
        practicesService.delete(id);
    }
}
