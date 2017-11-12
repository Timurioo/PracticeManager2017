package com.netcracker.pmbackend.impl.factory;

import com.netcracker.pmbackend.impl.entities.*;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * Created by dima on 11/8/2017.
 */
@Component
public class EntityFactory {

    public UsersEntity getUserEntity(String login, String password, String role){
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setLogin(login);
        usersEntity.setPassword(password);
        usersEntity.setRole(role);
        return usersEntity;
    }

    public HeadofpracticesEntity getHeadOfPracticeEntity(String name){
        HeadofpracticesEntity headofpracticesEntity = new HeadofpracticesEntity();
        headofpracticesEntity.setName(name);
        return headofpracticesEntity;
    }

    public StudentsEntity getStudentEntity(String name, String surname, String phone, String email, int specialityId, String group, double avrMark, String budget){
        StudentsEntity studentsEntity = new StudentsEntity();
        studentsEntity.setName(name);
        studentsEntity.setSurname(surname);
        studentsEntity.setPhone(phone);
        studentsEntity.setEmail(email);
        studentsEntity.setSpecialityId(specialityId);
        studentsEntity.setClassgroup(group);
        studentsEntity.setAvrMark(avrMark);
        studentsEntity.setBudget(budget);
        studentsEntity.setStatus("Available");
        return studentsEntity;
    }

    public PracticesEntity getPracticeEntity(int headOfPracticeId, String company, Date firstDate, Date finishDate, int totalQuantity, int facultyId, int specialityId, double avrMark){
        PracticesEntity practicesEntity = new PracticesEntity();
        practicesEntity.setHeadofpracticeId(headOfPracticeId);
        practicesEntity.setCompany(company);
        practicesEntity.setFirstDate(firstDate);
        practicesEntity.setFinishDate(finishDate);
        practicesEntity.setStatus("Available");
        practicesEntity.setTotalQuantity(totalQuantity);
        practicesEntity.setAvailableQuantity(totalQuantity);

        if(facultyId!=0) {
            practicesEntity.setFacultyId(facultyId);
        }
        if (specialityId!=0) {
            practicesEntity.setSpecialityId(specialityId);
        }
        if(avrMark!=0) {
            practicesEntity.setAvrMark(avrMark);
        }
        return practicesEntity;
    }

    public FacultyEntity getFacultyEntity(String name){
        FacultyEntity facultyEntity = new FacultyEntity();
        facultyEntity.setName(name);
        return facultyEntity;
    }

    public SpecialityEntity getSpecialityEntity(String name, int facultyId){
        SpecialityEntity specialityEntity = new SpecialityEntity();
        specialityEntity.setName(name);
        specialityEntity.setFacultyId(facultyId);
        return specialityEntity;
    }
}
