package com.netcracker.pmbackend.repository;

import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface StudentsRepository extends CrudRepository<StudentsEntity, Integer> {

    List<StudentsEntity> findByName(String name);
    List<StudentsEntity> findByGroup(String group);
    StudentsEntity findByUserId(int userId);
    List<StudentsEntity> findByStatus(String status);
}
