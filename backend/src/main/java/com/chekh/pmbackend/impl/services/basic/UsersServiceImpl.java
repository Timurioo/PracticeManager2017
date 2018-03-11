package com.chekh.pmbackend.impl.services.basic;

import com.chekh.pmbackend.impl.entities.UsersEntity;
import com.chekh.pmbackend.interfaces.basic.UsersService;
import com.chekh.pmbackend.repository.UsersRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("jpaUsersService")
@Transactional
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Transactional(readOnly = true)
    public List<UsersEntity> findAll() {
        return Lists.newArrayList(usersRepository.findAll());
    }

    @Transactional(readOnly = true)
    public UsersEntity findById(int id) {
        return usersRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public UsersEntity findByLogin(String login) {
        return usersRepository.findByLogin(login);
    }

    @Transactional(readOnly = true)
    public UsersEntity findByLoginAndPasswordAndRole(String login, String password, String role) {
        return usersRepository.findByLoginAndPasswordAndRole(login, password, role);
    }

    @Transactional(readOnly = true)
    public UsersEntity findByPassword(String password){
        return usersRepository.findByPassword(password);
    }

    public UsersEntity save(UsersEntity entity) {
        return usersRepository.save(entity);
    }

    public void delete(int id) {
        usersRepository.delete(id);
    }

}
