package com.chekh.pmbackend.interfaces.basic;


import com.chekh.pmbackend.impl.entities.AssignStudentsEntity;

import java.util.List;

public interface AssignStudentsService {

    List<AssignStudentsEntity> findAll();
    AssignStudentsEntity findById(int id);
    List<AssignStudentsEntity> findByStudentId(int studentId);
    List<AssignStudentsEntity> findByPracticeId(int practiceId);
    AssignStudentsEntity save(AssignStudentsEntity entity);
    Iterable<AssignStudentsEntity> save(List<AssignStudentsEntity> entities);
    void delete(int id);
}
