package com.netcracker.pmbackend.impl.services;


import com.google.common.collect.Lists;
import com.netcracker.pmbackend.impl.entities.AssignstudentsEntity;
import com.netcracker.pmbackend.interfaces.AssignStudentsService;
import com.netcracker.pmbackend.repository.AssignStudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaAssignStudentService")
@Repository
@Transactional
public class AssignStudentsServiceImpl implements AssignStudentsService {

    @Autowired
    private AssignStudentsRepository assignStudentsRepository;

    @Transactional(readOnly = true)
    public List<AssignstudentsEntity> findAll() {
        return Lists.newArrayList(assignStudentsRepository.findAll());
    }

    @Transactional(readOnly = true)
    public AssignstudentsEntity findById(int id) {
        return assignStudentsRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<AssignstudentsEntity> findByStudentId(int studentId) {
        return assignStudentsRepository.findByStudentId(studentId);
    }

    @Transactional(readOnly = true)
    public List<AssignstudentsEntity> findByPracticeId(int practiceId) {
        return assignStudentsRepository.findByPracticeId(practiceId);
    }
}

