package com.netcracker.pmbackend.impl.services;

import com.google.common.collect.Lists;
import com.netcracker.pmbackend.impl.entities.FacultyEntity;
import com.netcracker.pmbackend.interfaces.FacultyService;
import com.netcracker.pmbackend.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaFacultyService")
@Repository
@Transactional
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public List<FacultyEntity> findAll() {
        return Lists.newArrayList(facultyRepository.findAll());
    }


    public FacultyEntity findById(int id) {
        return facultyRepository.findOne(id);
    }


    public FacultyEntity findByName(String name) {
        return facultyRepository.findByName(name);
    }
}
