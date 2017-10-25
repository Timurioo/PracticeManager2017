package com.netcracker.pmbackend.impl.services;

import com.google.common.collect.Lists;
import com.netcracker.pmbackend.impl.entities.PracticesEntity;
import com.netcracker.pmbackend.interfaces.PracticesService;
import com.netcracker.pmbackend.repository.PracticesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaPracticesService")
@Repository
@Transactional
public class PracticesServicesImpl implements PracticesService {

    @Autowired
    private PracticesRepository practicesRepository;

    public List<PracticesEntity> findAll() {
        return Lists.newArrayList(practicesRepository.findAll());
    }


    public PracticesEntity findById(int id) {
        return practicesRepository.findOne(id);
    }


    public List<PracticesEntity> findByHeadofpracticeId(int id) {
        return practicesRepository.findByHeadofpracticeId(id);
    }


    public List<PracticesEntity> findByStatus(String status) {
        return practicesRepository.findByStatus(status);
    }
}
