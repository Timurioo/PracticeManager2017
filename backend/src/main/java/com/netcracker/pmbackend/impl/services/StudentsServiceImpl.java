package com.netcracker.pmbackend.impl.services;

import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import com.netcracker.pmbackend.interfaces.StudentsService;
import com.netcracker.pmbackend.repository.StudentsRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaStudentsService")
@Transactional
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAll() {
        return Lists.newArrayList(studentsRepository.findAll());
    }

    @Transactional(readOnly = true)
    public StudentsEntity findById(int id) {
        return studentsRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findByName(String name) {
        return studentsRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findByClassgroup(String classgroup) {
        return studentsRepository.findByClassgroup(classgroup);
    }

    @Transactional(readOnly = true)
    public StudentsEntity findByUserId(int userId) {
        return studentsRepository.findByUserId(userId);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findByStatus(String status) {
        return studentsRepository.findByStatus(status);
    }

    @Transactional(readOnly = true)
    public StudentsEntity findByEmail(String email) {
        return studentsRepository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public StudentsEntity findByPhone(String phone) {
        return studentsRepository.findByPhone(phone);
    }

    public StudentsEntity save(StudentsEntity entity) {
        return studentsRepository.save(entity);
    }

    public void delete(int id) {
        studentsRepository.delete(id);
    }

    @Override
    public List<StudentsEntity> findAllLimit(int limit, int offset) {
        return studentsRepository.findAllLimit(limit, offset);
    }

    @Override
    public List<StudentsEntity> findAllLimitSearch(String search, int limit, int offset) {
        return studentsRepository.findAllLimitSearch(search,limit,offset);
    }

    @Override
    public List<StudentsEntity> findAllSearch(String search) {
        return studentsRepository.findAllSearch(search);
    }

    @Override
    public List<StudentsEntity> findAllByCuratorId(int curatorId) {
        return studentsRepository.findAllByCuratorId(curatorId);
    }

    @Override
    public List<StudentsEntity> findAllByCuratorIdLimit(int curatorId, int limit, int offset) {
        return studentsRepository.findAllByCuratorIdLimit(curatorId, limit, offset);
    }

    @Override
    public List<StudentsEntity> findAllByCuratorIdSearch(int curatorId, String search) {
        return studentsRepository.findAllByCuratorIdSearch(curatorId, search);
    }

    @Override
    public List<StudentsEntity> findAllByCuratorIdSearchLimit(int curatorId, String search, int limit, int offset) {
        return studentsRepository.findAllByCuratorIdSearchLimit(curatorId, search, limit, offset);
    }

}
