package com.netcracker.pmbackend.repository;

import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface StudentsRepository extends CrudRepository<StudentsEntity, Integer> {

    List<StudentsEntity> findByName(String name);
    List<StudentsEntity> findByClassgroup(String classgroup);
    StudentsEntity findByUserId(int userId);
    List<StudentsEntity> findByStatus(String status);
    StudentsEntity findByEmail(String email);
    StudentsEntity findByPhone(String phone);

    @Query(value ="SELECT * FROM practicemanager.students LIMIT ?1 OFFSET ?2 " , nativeQuery = true)
    List<StudentsEntity> findAllLimit(int limit, int offset);

    @Query(value = "SELECT * FROM practicemanager.students where name LIKE %?1% " +
            "OR surname LIKE %?1% " +
            "OR budget LIKE %?1% " +
            "OR status LIKE %?1% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?1%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?1%)) " +
            "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<StudentsEntity> findAllLimitSearch(String search, int limit, int offset);

    @Query(value = "SELECT * FROM practicemanager.students where name LIKE %?1% " +
            "OR surname LIKE %?1% " +
            "OR budget LIKE %?1% " +
            "OR status LIKE %?1% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?1%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?1%)) ",
            nativeQuery = true)
    List<StudentsEntity> findAllSearch(String search);

    @Query(value = "SELECT * FROM practicemanager.students WHERE " +
            "id IN (SELECT student_id FROM practicemanager.assignstudents WHERE " +
            "practice_id IN (SELECT id FROM practicemanager.practices WHERE headofpractice_id=?1))",
            nativeQuery = true)
    List<StudentsEntity> findAllByCuratorId(int curatorId);

    @Query(value = "SELECT * FROM practicemanager.students WHERE " +
            "id IN (SELECT student_id FROM practicemanager.assignstudents WHERE " +
            "practice_id IN (SELECT id FROM practicemanager.practices WHERE headofpractice_id=?1))" +
            " LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<StudentsEntity> findAllByCuratorIdLimit(int curatorId, int limit, int offset);

    @Query(value = "SELECT * FROM practicemanager.students WHERE " +
            "id IN (SELECT student_id FROM practicemanager.assignstudents WHERE " +
            "practice_id IN (SELECT id FROM practicemanager.practices WHERE headofpractice_id=?1))"+
            "AND (name LIKE %?2% " +
            "OR surname LIKE %?2% " +
            "OR budget LIKE %?2% " +
            "OR status LIKE %?2% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?2%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?2%)))",
            nativeQuery = true)
    List<StudentsEntity> findAllByCuratorIdSearch(int curatorId, String search);

    @Query(value = "SELECT * FROM practicemanager.students WHERE " +
            "id IN (SELECT student_id FROM practicemanager.assignstudents WHERE " +
            "practice_id IN (SELECT id FROM practicemanager.practices WHERE headofpractice_id=?1))"+
            "AND (name LIKE %?2% " +
            "OR surname LIKE %?2% " +
            "OR budget LIKE %?2% " +
            "OR status LIKE %?2% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?2%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?2%))) " +
            "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<StudentsEntity> findAllByCuratorIdSearchLimit(int curatorId, String search, int limit, int offset);
}
