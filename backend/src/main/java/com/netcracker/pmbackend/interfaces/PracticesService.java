package com.netcracker.pmbackend.interfaces;


import com.netcracker.pmbackend.impl.entities.PracticesEntity;

import java.util.List;

public interface PracticesService {

    List<PracticesEntity> findAll();
    PracticesEntity findById(int id);
    List<PracticesEntity> findByHeadofpracticeId(int HeadofpracticeId);
    List<PracticesEntity> findByStatus(String status);
}
