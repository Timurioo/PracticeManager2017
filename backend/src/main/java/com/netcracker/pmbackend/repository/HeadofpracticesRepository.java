package com.netcracker.pmbackend.repository;

import com.netcracker.pmbackend.impl.entities.HeadofpracticesEntity;
import org.springframework.data.repository.CrudRepository;


public interface HeadofpracticesRepository extends CrudRepository<HeadofpracticesEntity, Integer> {

    HeadofpracticesEntity findByUserId(int userId);
}
