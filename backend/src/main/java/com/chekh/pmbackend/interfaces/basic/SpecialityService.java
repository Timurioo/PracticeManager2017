package com.chekh.pmbackend.interfaces.basic;

import com.chekh.pmbackend.impl.entities.SpecialityEntity;

import java.util.List;

public interface SpecialityService {

    List<SpecialityEntity> findAll();
    SpecialityEntity findById(int id);
    List<SpecialityEntity> findByFacultyId(int facultyId);
    SpecialityEntity findByName(String name);
    SpecialityEntity save(SpecialityEntity entity);
}
