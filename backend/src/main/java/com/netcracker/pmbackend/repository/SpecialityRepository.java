package com.netcracker.pmbackend.repository;

import com.netcracker.pmbackend.impl.entities.SpecialityEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface SpecialityRepository extends CrudRepository<SpecialityEntity, Integer> {

    List<SpecialityEntity> findByFacultyId(int facultyId);
}
