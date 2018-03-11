package com.chekh.pmbackend.impl.services.basic;

import com.chekh.pmbackend.impl.entities.HeadofpracticesEntity;
import com.chekh.pmbackend.interfaces.basic.HeadofpracticesService;
import com.chekh.pmbackend.repository.HeadofpracticesRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaHeadofpracticesService")
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

    @Transactional(readOnly = true)
    public HeadofpracticesEntity findByName(String name){
        return headofpracticesRepository.findByName(name);
    }

    public HeadofpracticesEntity save(HeadofpracticesEntity entity){
        return headofpracticesRepository.save(entity);
    }
}
