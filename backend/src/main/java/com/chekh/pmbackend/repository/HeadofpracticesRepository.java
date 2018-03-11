package com.chekh.pmbackend.repository;

import com.chekh.pmbackend.impl.entities.HeadofpracticesEntity;
import org.springframework.data.repository.CrudRepository;


public interface HeadofpracticesRepository extends CrudRepository<HeadofpracticesEntity, Integer> {

    HeadofpracticesEntity findByUserId(int userId);
    HeadofpracticesEntity findByName(String name);
}
