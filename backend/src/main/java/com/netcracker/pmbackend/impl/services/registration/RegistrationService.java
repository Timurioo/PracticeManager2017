package com.netcracker.pmbackend.impl.services.registration;

import com.netcracker.pmbackend.impl.entities.HeadofpracticesEntity;
import com.netcracker.pmbackend.impl.entities.SpecialityEntity;
import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import com.netcracker.pmbackend.impl.entities.UsersEntity;
import com.netcracker.pmbackend.interfaces.HeadofpracticesService;
import com.netcracker.pmbackend.interfaces.SpecialityService;
import com.netcracker.pmbackend.interfaces.StudentsService;
import com.netcracker.pmbackend.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dima on 11/8/2017.
 */
@Service
@Transactional
public class RegistrationService {


    @Autowired
    private UsersService usersService;

    @Autowired
    private HeadofpracticesService headofpracticesService;

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private SpecialityService specialityService;

    @Transactional
    public void registrateHeadOfPractice(UsersEntity usersEntity, HeadofpracticesEntity headofpracticesEntity){
        usersService.save(usersEntity);
        UsersEntity registerUser = usersService.findByLogin(usersEntity.getLogin());
        headofpracticesEntity.setUserId(registerUser.getId());
        headofpracticesEntity.setUsersByUserId(registerUser);
        headofpracticesService.save(headofpracticesEntity);
    }

    @Transactional
    public void registrateStudent(UsersEntity usersEntity, StudentsEntity studentsEntity){
        usersService.save(usersEntity);

        UsersEntity registerUser = usersService.findByLogin(usersEntity.getLogin());
        studentsEntity.setUserId(registerUser.getId());
        studentsEntity.setUsersByUserId(registerUser);

        SpecialityEntity specialityEntity = specialityService.findById(studentsEntity.getSpecialityId());
        studentsEntity.setSpecialityBySpecialityId(specialityEntity);

        studentsService.save(studentsEntity);
    }


}
