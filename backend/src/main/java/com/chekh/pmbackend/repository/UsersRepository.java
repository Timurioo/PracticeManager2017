package com.chekh.pmbackend.repository;

import com.chekh.pmbackend.impl.entities.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {

    UsersEntity findByLoginAndPasswordAndRole(String login, String password, String role);
    UsersEntity findByLogin(String login);
    UsersEntity findByPassword(String password);
}
