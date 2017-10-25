package com.netcracker.pmbackend.repository;

import com.netcracker.pmbackend.impl.entities.AssignstudentsEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface AssignStudentsRepository extends CrudRepository<AssignstudentsEntity, Integer> {

    List<AssignstudentsEntity> findByStudentId(int studentId);
    List<AssignstudentsEntity> findByPracticeId(int practiceId);
}
