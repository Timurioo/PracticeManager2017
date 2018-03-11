package com.chekh.pmbackend.interfaces.deletion;

/**
 * Created by dima on 12/20/2017.
 */
public interface DeletionService {
    void deleteStudent(int id);
    void deletePractice(int id);
    void deleteAssignStudent(int studentId);
}
