package com.netcracker.pmbackend.interfaces;

import com.netcracker.pmbackend.impl.entities.StudentsEntity;


import java.util.List;

/**
 * Created by dima on 10/23/2017.
 */
public interface StudentsService {

    List<StudentsEntity> findAll();
    List<StudentsEntity> findByName(String name);
    List<StudentsEntity> findByGroup(String group);
}
