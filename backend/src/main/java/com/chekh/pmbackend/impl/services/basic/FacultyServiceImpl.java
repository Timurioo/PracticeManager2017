package com.chekh.pmbackend.impl.services.basic;

import com.chekh.pmbackend.impl.entities.FacultyEntity;
import com.chekh.pmbackend.repository.FacultyRepository;
import com.google.common.collect.Lists;
import com.chekh.pmbackend.interfaces.basic.FacultyService;
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
