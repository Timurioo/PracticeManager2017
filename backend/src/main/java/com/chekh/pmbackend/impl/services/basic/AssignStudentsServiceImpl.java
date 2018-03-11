package com.chekh.pmbackend.impl.services.basic;


import com.chekh.pmbackend.impl.entities.AssignStudentsEntity;
import com.chekh.pmbackend.interfaces.basic.AssignStudentsService;
import com.chekh.pmbackend.repository.AssignStudentsRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
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

    public AssignStudentsEntity save(AssignStudentsEntity entity) {
        return assignStudentsRepository.save(entity);
    }

    public Iterable<AssignStudentsEntity> save(List<AssignStudentsEntity> entities){

        return assignStudentsRepository.save(entities);
    }

    public void delete(int id){
        assignStudentsRepository.delete(id);
    }

}

