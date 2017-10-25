package com.netcracker.pmbackend.impl.services;

import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import com.netcracker.pmbackend.interfaces.StudentsService;
import com.netcracker.pmbackend.repository.StudentsRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaStudentsService")
@Repository
@Transactional
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;


    public List<StudentsEntity> findAll() {
        return Lists.newArrayList(studentsRepository.findAll());
    }


    public StudentsEntity findById(int id) {
        return studentsRepository.findOne(id);
    }


    public List<StudentsEntity> findByName(String name) {
        return studentsRepository.findByName(name);
    }


    public List<StudentsEntity> findByGroup(String group) {
        return studentsRepository.findByGroup(group);
    }


    public StudentsEntity findByUserId(int userId) {
        return studentsRepository.findByUserId(userId);
    }


    public List<StudentsEntity> findByStatus(String status) {
        return studentsRepository.findByStatus(status);
    }
}
