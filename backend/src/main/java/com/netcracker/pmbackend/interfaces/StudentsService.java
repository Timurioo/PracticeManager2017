package com.netcracker.pmbackend.interfaces;

import com.netcracker.pmbackend.impl.entities.StudentsEntity;


import java.util.List;


public interface StudentsService {

    List<StudentsEntity> findAll();
    StudentsEntity findById(int id);
    List<StudentsEntity> findByName(String name);
    List<StudentsEntity> findByGroup(String group);
    StudentsEntity findByUserId(int userId);
    List<StudentsEntity> findByStatus(String status);
}
