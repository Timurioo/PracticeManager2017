package com.chekh.pmbackend.impl.services.basic;

import com.chekh.pmbackend.impl.entities.SpecialityEntity;
import com.chekh.pmbackend.interfaces.basic.SpecialityService;
import com.chekh.pmbackend.repository.SpecialityRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaSpecialityService")
@Transactional
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    @Transactional(readOnly = true)
    public List<SpecialityEntity> findAll() {
        return Lists.newArrayList(specialityRepository.findAll());
    }

    @Transactional(readOnly = true)
    public SpecialityEntity findById(int id) {
        return specialityRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<SpecialityEntity> findByFacultyId(int facultyId) {
        return specialityRepository.findByFacultyId(facultyId);
    }

    @Transactional(readOnly = true)
    public SpecialityEntity findByName(String name) {
        return specialityRepository.findByName(name);
    }

    public SpecialityEntity save(SpecialityEntity entity) {
        return specialityRepository.save(entity);
    }

}
