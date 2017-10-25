package com.netcracker.pmbackend.repository;

import com.netcracker.pmbackend.impl.entities.UsersEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<UsersEntity, Integer> {

    UsersEntity findByLoginAndPasswordAndRole(String login, String password, String role);
}
