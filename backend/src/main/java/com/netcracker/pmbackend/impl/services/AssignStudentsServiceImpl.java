package com.netcracker.pmbackend.impl.services;


import com.google.common.collect.Lists;
import com.netcracker.pmbackend.impl.entities.AssignStudentsEntity;
import com.netcracker.pmbackend.interfaces.AssignStudentsService;
import com.netcracker.pmbackend.repository.AssignStudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaAssignStudentService")
@Transactional
public class AssignStudentsServiceImpl implements AssignStudentsService {

    @Autowired
    private AssignStudentsRepository assignStudentsRepository;

    @Transactional(readOnly = true)
    public List<AssignStudentsEntity> findAll() {
        return Lists.newArrayList(assignStudentsRepository.findAll());
    }

    @Transactional(readOnly = true)
    public AssignStudentsEntity findById(int id) {
        return assignStudentsRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<AssignStudentsEntity> findByStudentId(int studentId) {
        return assignStudentsRepository.findByStudentId(studentId);
    }

    @Transactional(readOnly = true)
    public List<AssignStudentsEntity> findByPracticeId(int practiceId) {
        return assignStudentsRepository.findByPracticeId(practiceId);
    }
}

