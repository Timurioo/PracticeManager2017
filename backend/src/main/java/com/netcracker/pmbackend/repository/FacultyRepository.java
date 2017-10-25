package com.netcracker.pmbackend.repository;

import com.netcracker.pmbackend.impl.entities.FacultyEntity;
import org.springframework.data.repository.CrudRepository;


public interface FacultyRepository extends CrudRepository<FacultyEntity, Integer> {

    FacultyEntity findByName(String name);
}
