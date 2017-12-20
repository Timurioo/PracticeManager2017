package com.netcracker.pmbackend.interfaces.basic;

import com.netcracker.pmbackend.impl.entities.FacultyEntity;

import java.util.List;


public interface FacultyService {

    List<FacultyEntity> findAll();
    FacultyEntity findById(int id);
    FacultyEntity findByName(String name);
    FacultyEntity save(FacultyEntity entity);
}
