package com.netcracker.pmbackend.interfaces;


import com.netcracker.pmbackend.impl.entities.AssignstudentsEntity;

import java.util.List;

public interface AssignStudentsService {

    List<AssignstudentsEntity> findAll();
    AssignstudentsEntity findById(int id);
    List<AssignstudentsEntity> findByStudentId(int studentId);
    List<AssignstudentsEntity> findByPracticeId(int practiceId);
}
