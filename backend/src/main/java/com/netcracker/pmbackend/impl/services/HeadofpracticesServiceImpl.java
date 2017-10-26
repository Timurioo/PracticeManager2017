package com.netcracker.pmbackend.impl.services;

import com.google.common.collect.Lists;
import com.netcracker.pmbackend.impl.entities.HeadofpracticesEntity;
import com.netcracker.pmbackend.interfaces.HeadofpracticesService;
import com.netcracker.pmbackend.repository.HeadofpracticesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaHeadofpracticesService")
@Repository
@Transactional
public class HeadofpracticesServiceImpl implements HeadofpracticesService {

    @Autowired
    private HeadofpracticesRepository headofpracticesRepository;

    @Transactional(readOnly = true)
    public List<HeadofpracticesEntity> findAll() {
        return Lists.newArrayList(headofpracticesRepository.findAll());
    }

    @Transactional(readOnly = true)
    public HeadofpracticesEntity findById(int id) {
        return headofpracticesRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public HeadofpracticesEntity findByUserId(int userId) {
        return headofpracticesRepository.findByUserId(userId);
    }
}
