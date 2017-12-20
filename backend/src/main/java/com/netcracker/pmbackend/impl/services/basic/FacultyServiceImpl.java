package com.netcracker.pmbackend.impl.services.basic;

import com.google.common.collect.Lists;
import com.netcracker.pmbackend.impl.entities.FacultyEntity;
import com.netcracker.pmbackend.interfaces.basic.FacultyService;
import com.netcracker.pmbackend.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaFacultyService")
@Transactional
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Transactional(readOnly = true)
    public List<FacultyEntity> findAll() {
        return Lists.newArrayList(facultyRepository.findAll());
    }

    @Transactional(readOnly = true)
    public FacultyEntity findById(int id) {
        return facultyRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public FacultyEntity findByName(String name) {
        return facultyRepository.findByName(name);
    }

    public FacultyEntity save(FacultyEntity entity) {
        return facultyRepository.save(entity);
    }


}
