package com.chekh.pmbackend.interfaces.basic;

import com.chekh.pmbackend.impl.entities.UsersEntity;

import java.util.List;


public interface UsersService {

    List<UsersEntity> findAll();
    UsersEntity findById(int id);
    UsersEntity findByLogin(String login);
    UsersEntity findByLoginAndPasswordAndRole(String login, String password, String role);
    UsersEntity findByPassword(String password);
    UsersEntity save(UsersEntity entity);
    void delete(int id);
}
