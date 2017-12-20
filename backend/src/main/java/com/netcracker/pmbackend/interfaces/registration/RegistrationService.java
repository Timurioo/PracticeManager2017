package com.netcracker.pmbackend.interfaces.registration;

import com.netcracker.pmbackend.impl.entities.*;

/**
 * Created by dima on 12/20/2017.
 */
public interface RegistrationService {
    void registrateHeadOfPractice(UsersEntity usersEntity, HeadofpracticesEntity headofpracticesEntity);
    void registrateStudent(UsersEntity usersEntity, StudentsEntity studentsEntity);
    void registrateFaculty(FacultyEntity facultyEntity);
    void registrateSpeciality(SpecialityEntity specialityEntity);
    void registratePractice(PracticesEntity practicesEntity);
}
