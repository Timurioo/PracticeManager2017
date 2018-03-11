package com.chekh.pmbackend.repository;

import com.chekh.pmbackend.impl.entities.AssignStudentsEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface AssignStudentsRepository extends CrudRepository<AssignStudentsEntity, Integer> {

    List<AssignStudentsEntity> findByStudentId(int studentId);
    List<AssignStudentsEntity> findByPracticeId(int practiceId);
}
