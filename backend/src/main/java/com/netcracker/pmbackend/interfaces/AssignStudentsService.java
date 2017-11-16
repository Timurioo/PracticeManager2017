package com.netcracker.pmbackend.interfaces;


import com.netcracker.pmbackend.impl.entities.AssignStudentsEntity;

import java.util.List;

public interface AssignStudentsService {

    List<AssignStudentsEntity> findAll();
    AssignStudentsEntity findById(int id);
    List<AssignStudentsEntity> findByStudentId(int studentId);
    List<AssignStudentsEntity> findByPracticeId(int practiceId);
    AssignStudentsEntity save(AssignStudentsEntity entity);
    Iterable<AssignStudentsEntity> save(List<AssignStudentsEntity> entities);
}
