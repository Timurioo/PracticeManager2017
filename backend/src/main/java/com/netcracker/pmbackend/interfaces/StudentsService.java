package com.netcracker.pmbackend.interfaces;

import com.netcracker.pmbackend.impl.entities.StudentsEntity;


import java.util.List;


public interface StudentsService {

    List<StudentsEntity> findAll();
    StudentsEntity findById(int id);
    List<StudentsEntity> findByName(String name);
    List<StudentsEntity> findByClassgroup(String classgroup);
    StudentsEntity findByUserId(int userId);
    List<StudentsEntity> findByStatus(String status);
    StudentsEntity findByEmail(String email);
    StudentsEntity findByPhone(String phone);
    StudentsEntity save(StudentsEntity entity);
    void delete(int id);
}
