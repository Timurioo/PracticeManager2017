package com.netcracker.pmbackend.interfaces;

import com.netcracker.pmbackend.impl.entities.HeadofpracticesEntity;

import java.util.List;

public interface HeadofpracticesService {

    List<HeadofpracticesEntity> findAll();
    HeadofpracticesEntity findById(int id);
    HeadofpracticesEntity findByUserId(int userId);
}
