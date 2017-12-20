package com.netcracker.pmbackend.impl.services.basic;

import com.google.common.collect.Lists;
import com.netcracker.pmbackend.impl.entities.PracticesEntity;
import com.netcracker.pmbackend.interfaces.basic.PracticesService;
import com.netcracker.pmbackend.repository.PracticesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaPracticesService")
@Transactional
public class PracticesServicesImpl implements PracticesService {

    @Autowired
    private PracticesRepository practicesRepository;

    @Transactional(readOnly = true)
    public List<PracticesEntity> findAll() {
        return Lists.newArrayList(practicesRepository.findAll());
    }

    @Transactional(readOnly = true)
    public PracticesEntity findById(int id) {
        return practicesRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<PracticesEntity> findByCuratorId(int id) {
        return practicesRepository.findByHeadofpracticeId(id);
    }

    @Transactional(readOnly = true)
    public List<PracticesEntity> findByStatus(String status) {
        return practicesRepository.findByStatus(status);
    }

    @Transactional(readOnly = true)
    public PracticesEntity findByCompany(String company) {
        return practicesRepository.findByCompany(company);
    }

    public PracticesEntity save(PracticesEntity entity) {
        return practicesRepository.save(entity);
    }

    public void delete(int id) {
        practicesRepository.delete(id);
    }

    public List<PracticesEntity> findAllLimit(int limit, int offset) {
        return practicesRepository.findAllLimit(limit,offset);
    }

    public List<PracticesEntity> findAllLimitSearch(String search, int limit, int offset) {
        return practicesRepository.findAllLimitSearch(search,limit,offset);
    }

    public List<PracticesEntity> findAllSearch(String search) {
        return practicesRepository.findAllSearch(search);
    }

    @Override
    public List<PracticesEntity> findAllByCuratorIdLimit(int curatorId, int limit, int offset) {
        return practicesRepository.findByCuratorIdLimit(curatorId, limit, offset);
    }

    @Override
    public List<PracticesEntity> findAllByCuratorIdSearch(int curatorId, String search) {
        return practicesRepository.findByCuratorIdSearch(curatorId, search);
    }

    @Override
    public List<PracticesEntity> findAllByCuratorIdSearchLimit(int curatorId, String search, int limit, int offset) {
        return practicesRepository.findByCuratorIdSearchLimit(curatorId, search, limit, offset);
    }

}
