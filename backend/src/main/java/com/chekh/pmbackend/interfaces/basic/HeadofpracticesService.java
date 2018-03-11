package com.chekh.pmbackend.interfaces.basic;

import com.chekh.pmbackend.impl.entities.HeadofpracticesEntity;

import java.util.List;

public interface HeadofpracticesService {

    List<HeadofpracticesEntity> findAll();
    HeadofpracticesEntity findById(int id);
    HeadofpracticesEntity findByUserId(int userId);
    HeadofpracticesEntity findByName(String name);
    HeadofpracticesEntity save(HeadofpracticesEntity entity);
}
