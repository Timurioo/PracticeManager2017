package com.netcracker.pmbackend.repository;

import com.netcracker.pmbackend.impl.entities.PracticesEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PracticesRepository extends CrudRepository<PracticesEntity, Integer> {

    List<PracticesEntity> findByHeadofpracticeId(int headofpracticeId);
    List<PracticesEntity> findByStatus(String status);
    PracticesEntity findByCompany(String company);
}
