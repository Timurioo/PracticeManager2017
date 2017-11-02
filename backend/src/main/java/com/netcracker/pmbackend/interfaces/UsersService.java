package com.netcracker.pmbackend.interfaces;

import com.netcracker.pmbackend.impl.entities.UsersEntity;

import java.util.List;


public interface UsersService {

    List<UsersEntity> findAll();
    UsersEntity findById(int id);
    UsersEntity findByLogin(String login);
    UsersEntity findByLoginAndPasswordAndRole(String login, String password, String role);
    void createUsers(List<UsersEntity> usersEntity);
}
