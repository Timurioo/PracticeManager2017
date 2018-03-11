package com.chekh.pmbackend.interfaces.basic;


import com.chekh.pmbackend.impl.entities.PracticesEntity;

import java.util.List;

public interface PracticesService {

    List<PracticesEntity> findAll();
    PracticesEntity findById(int id);
    List<PracticesEntity> findByCuratorId(int HeadofpracticeId);
    List<PracticesEntity> findByStatus(String status);
    PracticesEntity findByCompany(String company);
    PracticesEntity save(PracticesEntity entity);
    void delete(int id);
    List<PracticesEntity> findAllLimit(int limit, int offset);
    List<PracticesEntity> findAllLimitSearch(String search, int limit, int offset );
    List<PracticesEntity> findAllSearch(String search);
    List<PracticesEntity> findAllByCuratorIdLimit(int curatorId, int limit, int offset);
    List<PracticesEntity> findAllByCuratorIdSearch(int curatorId, String search);
    List<PracticesEntity> findAllByCuratorIdSearchLimit(int curatorId, String search, int limit, int offset);
}
