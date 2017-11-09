package com.netcracker.pmbackend.repository;

import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface StudentsRepository extends CrudRepository<StudentsEntity, Integer> {

    List<StudentsEntity> findByName(String name);
    List<StudentsEntity> findByClassgroup(String classgroup);
    StudentsEntity findByUserId(int userId);
    List<StudentsEntity> findByStatus(String status);
    StudentsEntity findByEmail(String email);
    StudentsEntity findByPhone(String phone);
}
