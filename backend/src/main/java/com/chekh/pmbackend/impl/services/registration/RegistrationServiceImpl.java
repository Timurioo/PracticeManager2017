package com.chekh.pmbackend.impl.services.registration;

import com.chekh.pmbackend.impl.entities.*;
import com.chekh.pmbackend.interfaces.basic.*;
import com.chekh.pmbackend.interfaces.registration.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by dima on 11/8/2017.
 */
@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {


    @Autowired
    private UsersService usersService;

    @Autowired
    private HeadofpracticesService headofpracticesService;

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private FacultyService facultyService;

    @Autowired
    private PracticesService practicesService;

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

    @Transactional
    public void registrateFaculty(FacultyEntity facultyEntity){
        facultyService.save(facultyEntity);
    }

    @Transactional
    public void registrateSpeciality(SpecialityEntity specialityEntity){
        FacultyEntity facultyEntity = facultyService.findById(specialityEntity.getFacultyId());
        specialityEntity.setFacultyByFacultyId(facultyEntity);
        specialityService.save(specialityEntity);
    }

    @Transactional
    public void registratePractice(PracticesEntity practicesEntity){
        HeadofpracticesEntity headofpracticesEntity = headofpracticesService.findById(practicesEntity.getHeadofpracticeId());
        practicesEntity.setHeadofpracticesByHeadofpracticeId(headofpracticesEntity);

        if(practicesEntity.getFacultyId() != null){
            FacultyEntity facultyEntity = facultyService.findById(practicesEntity.getFacultyId());
            practicesEntity.setFacultyByFacultyId(facultyEntity);
            if(practicesEntity.getSpecialityId() != null){
                SpecialityEntity specialityEntity = specialityService.findById(practicesEntity.getSpecialityId());
                practicesEntity.setSpecialityBySpecialityId(specialityEntity);
            }
        }

        practicesService.save(practicesEntity);
    }

}
