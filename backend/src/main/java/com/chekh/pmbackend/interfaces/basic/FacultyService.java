package com.chekh.pmbackend.interfaces.basic;

import com.chekh.pmbackend.impl.entities.FacultyEntity;

import java.util.List;


public interface FacultyService {

    List<FacultyEntity> findAll();
    FacultyEntity findById(int id);
    FacultyEntity findByName(String name);
    FacultyEntity save(FacultyEntity entity);
}
