package com.netcracker.pmbackend.repository;

import com.netcracker.pmbackend.impl.entities.AssignStudentsEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface AssignStudentsRepository extends CrudRepository<AssignStudentsEntity, Integer> {

    List<AssignStudentsEntity> findByStudentId(int studentId);
    List<AssignStudentsEntity> findByPracticeId(int practiceId);
}
