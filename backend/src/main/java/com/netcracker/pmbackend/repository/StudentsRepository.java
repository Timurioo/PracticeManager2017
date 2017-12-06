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

    //Find all
    @Query(value ="SELECT * FROM practicemanager.students " +
            "LIMIT ?1 OFFSET ?2 ",
            nativeQuery = true)
    List<StudentsEntity> findAllLimit(int limit, int offset);


    //Search all
    @Query(value = "SELECT * FROM practicemanager.students where name LIKE %?1% " +
            "OR surname LIKE %?1% " +
            "OR budget LIKE %?1% " +
            "OR status LIKE %?1% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?1%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?1%)) " +
            "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<StudentsEntity> findAllLimitSearch(String search, int limit, int offset);

    @Query(value = "SELECT count(*) FROM practicemanager.students where name LIKE %?1% " +
            "OR surname LIKE %?1% " +
            "OR budget LIKE %?1% " +
            "OR status LIKE %?1% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?1%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?1%)) ",
            nativeQuery = true)
    int countAllSearch(String search);
    /////////////////////////////


    //Sort order by surname
    @Query(value ="SELECT count(*) FROM practicemanager.students " +
            "ORDER BY surname ASC" , nativeQuery = true)
    int countAllOrderBySurnameAsc();

    @Query(value ="SELECT * FROM practicemanager.students " +
            "ORDER BY surname ASC LIMIT ?1 OFFSET ?2 " , nativeQuery = true)
    List<StudentsEntity> findAllOrderBySurnameAscLimit(int limit, int offset);

    @Query(value ="SELECT count(*) FROM practicemanager.students " +
            "ORDER BY surname DESC" ,nativeQuery = true)
    int countAllOrderBySurnameDesc();

    @Query(value ="SELECT * FROM practicemanager.students " +
            "ORDER BY surname DESC LIMIT ?1 OFFSET ?2 " , nativeQuery = true)
    List<StudentsEntity> findAllOrderBySurnameDescLimit(int limit, int offset);
    /////////////////////////////


    //Sort order by average mark
    @Query(value ="SELECT count(*) FROM practicemanager.students " +
            "ORDER BY avr_mark ASC" , nativeQuery = true)
    int countAllOrderByAvrMarkAsc();

    @Query(value ="SELECT * FROM practicemanager.students " +
            "ORDER BY avr_mark ASC LIMIT ?1 OFFSET ?2 " , nativeQuery = true)
    List<StudentsEntity> findAllOrderByAvrMarkAscLimit(int limit, int offset);

    @Query(value ="SELECT count(*) FROM practicemanager.students " +
            "ORDER BY avr_mark DESC" ,nativeQuery = true)
    int countAllOrderByAvrMarkDesc();

    @Query(value ="SELECT * FROM practicemanager.students " +
            "ORDER BY avr_mark DESC LIMIT ?1 OFFSET ?2 " , nativeQuery = true)
    List<StudentsEntity> findAllOrderByAvrMarkDescLimit(int limit, int offset);
    //////////////////////////////


    //Search and Sort order by surname
    @Query(value = "SELECT count(*) FROM practicemanager.students where name LIKE %?1% " +
            "OR surname LIKE %?1% " +
            "OR budget LIKE %?1% " +
            "OR status LIKE %?1% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?1%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?1%)) " +
            "ORDER BY surname ASC",
            nativeQuery = true)
    int countAllSearchOrderBySurnameAsc(String search);

    @Query(value = "SELECT * FROM practicemanager.students where name LIKE %?1% " +
            "OR surname LIKE %?1% " +
            "OR budget LIKE %?1% " +
            "OR status LIKE %?1% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?1%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?1%)) " +
            "ORDER BY surname ASC " +
            "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<StudentsEntity> findAllSearchOrderBySurnameAscLimit(String search, int limit, int offset);

    @Query(value = "SELECT count(*) FROM practicemanager.students where name LIKE %?1% " +
            "OR surname LIKE %?1% " +
            "OR budget LIKE %?1% " +
            "OR status LIKE %?1% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?1%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?1%)) " +
            "ORDER BY surname DESC",
            nativeQuery = true)
    int countAllSearchOrderBySurnameDesc(String search);

    @Query(value = "SELECT * FROM practicemanager.students where name LIKE %?1% " +
            "OR surname LIKE %?1% " +
            "OR budget LIKE %?1% " +
            "OR status LIKE %?1% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?1%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?1%)) " +
            "ORDER BY surname DESC " +
            "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<StudentsEntity> findAllSearchOrderBySurnameDescLimit(String search, int limit, int offset);
    ///////////////////////////////


    //Search and Sort order by average mark
    @Query(value = "SELECT count(*) FROM practicemanager.students where name LIKE %?1% " +
            "OR surname LIKE %?1% " +
            "OR budget LIKE %?1% " +
            "OR status LIKE %?1% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?1%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?1%)) " +
            "ORDER BY avr_mark ASC",
            nativeQuery = true)
    int countAllSearchOrderByAvrMarkAsc(String search);

    @Query(value = "SELECT * FROM practicemanager.students where name LIKE %?1% " +
            "OR surname LIKE %?1% " +
            "OR budget LIKE %?1% " +
            "OR status LIKE %?1% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?1%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?1%)) " +
            "ORDER BY avr_mark ASC " +
            "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<StudentsEntity> findAllSearchOrderByAvrMarkAscLimit(String search, int limit, int offset);

    @Query(value = "SELECT count(*) FROM practicemanager.students where name LIKE %?1% " +
            "OR surname LIKE %?1% " +
            "OR budget LIKE %?1% " +
            "OR status LIKE %?1% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?1%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?1%)) " +
            "ORDER BY avr_mark DESC",
            nativeQuery = true)
    int countAllSearchOrderByAvrMarkDesc(String search);

    @Query(value = "SELECT * FROM practicemanager.students where name LIKE %?1% " +
            "OR surname LIKE %?1% " +
            "OR budget LIKE %?1% " +
            "OR status LIKE %?1% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?1%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?1%)) " +
            "ORDER BY avr_mark DESC " +
            "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<StudentsEntity> findAllSearchOrderByAvrMarkDescLimit(String search, int limit, int offset);
    ////////////////////////////////


    //Find by curator
    @Query(value = "SELECT count(*) FROM practicemanager.students WHERE " +
            "id IN (SELECT student_id FROM practicemanager.assignstudents WHERE " +
            "practice_id IN (SELECT id FROM practicemanager.practices WHERE headofpractice_id=?1))",
            nativeQuery = true)
    int countAllByCuratorId(int curatorId);

    @Query(value = "SELECT * FROM practicemanager.students WHERE " +
            "id IN (SELECT student_id FROM practicemanager.assignstudents WHERE " +
            "practice_id IN (SELECT id FROM practicemanager.practices WHERE headofpractice_id=?1))" +
            " LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<StudentsEntity> findAllByCuratorIdLimit(int curatorId, int limit, int offset);
    ////////////////////////////////


    //Search and Find by curator
    @Query(value = "SELECT count(*) FROM practicemanager.students WHERE " +
            "id IN (SELECT student_id FROM practicemanager.assignstudents WHERE " +
            "practice_id IN (SELECT id FROM practicemanager.practices WHERE headofpractice_id=?1))"+
            "AND (name LIKE %?2% " +
            "OR surname LIKE %?2% " +
            "OR budget LIKE %?2% " +
            "OR status LIKE %?2% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?2%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?2%)))",
            nativeQuery = true)
    int countAllByCuratorIdSearch(int curatorId, String search);

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
    ///////////////////////////////////////////////////////////////


    //Filter all data
    @Query(value = "SELECT count(*) FROM practicemanager.students where " +
            "budget LIKE %?1% " +
            "AND status LIKE %?2% ",
            nativeQuery = true)
    int countAllByFilter(String filterBudget, String filterStatus);

    @Query(value = "SELECT * FROM practicemanager.students where " +
            "budget LIKE %?1% " +
            "AND status LIKE %?2% " +
            "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<StudentsEntity> findAllByFilterLimit(String filterBudget, String filterStatus, int limit, int offset);
    /////////////////////////////////////////////////////////////////


    //Filter and Sort order by surname
    @Query(value = "SELECT count(*) FROM practicemanager.students where " +
            "budget LIKE %?1% " +
            "AND status LIKE %?2% " +
            "ORDER BY surname ASC",
            nativeQuery = true)
    int countAllByFilterOrderBySurnameAsc(String filterBudget, String filterStatus);

    @Query(value = "SELECT * FROM practicemanager.students where " +
            "budget LIKE %?1% " +
            "AND status LIKE %?2% " +
            "ORDER BY surname ASC " +
            "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<StudentsEntity> findAllByFilterOrderBySurnameAscLimit(String filterBudget, String filterStatus, int limit, int offset);

    @Query(value = "SELECT count(*) FROM practicemanager.students where " +
            "budget LIKE %?1% " +
            "AND status LIKE %?2% " +
            "ORDER BY surname DESC",
            nativeQuery = true)
    int countAllByFilterOrderBySurnameDesc(String filterBudget, String filterStatus);

    @Query(value = "SELECT * FROM practicemanager.students where " +
            "budget LIKE %?1% " +
            "AND status LIKE %?2% " +
            "ORDER BY surname DESC " +
            "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<StudentsEntity> findAllByFilterOrderBySurnameDescLimit(String filterBudget, String filterStatus, int limit, int offset);
    //////////////////////////////////////////////////////////////////

    //Filter and Sort order by average mark
    @Query(value = "SELECT count(*) FROM practicemanager.students where " +
            "budget LIKE %?1% " +
            "AND status LIKE %?2% " +
            "ORDER BY avr_mark ASC",
            nativeQuery = true)
    int countAllByFilterOrderByAvrMarkAsc(String filterBudget, String filterStatus);

    @Query(value = "SELECT * FROM practicemanager.students where " +
            "budget LIKE %?1% " +
            "AND status LIKE %?2% " +
            "ORDER BY avr_mark ASC " +
            "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<StudentsEntity> findAllByFilterOrderByAvrMarkAscLimit(String filterBudget, String filterStatus, int limit, int offset);

    @Query(value = "SELECT count(*) FROM practicemanager.students where " +
            "budget LIKE %?1% " +
            "AND status LIKE %?2% " +
            "ORDER BY avr_mark DESC",
            nativeQuery = true)
    int countAllByFilterOrderByAvrMarkDesc(String filterBudget, String filterStatus);

    @Query(value = "SELECT * FROM practicemanager.students where " +
            "budget LIKE %?1% " +
            "AND status LIKE %?2% " +
            "ORDER BY avr_mark DESC " +
            "LIMIT ?3 OFFSET ?4",
            nativeQuery = true)
    List<StudentsEntity> findAllByFilterOrderByAvrMarkDescLimit(String filterBudget, String filterStatus, int limit, int offset);
    ///////////////////////////////////////////////////////////////

    //Filter and Search all
    @Query(value = "SELECT * FROM practicemanager.students where " +
            "(budget LIKE %?1% " +
            "AND status LIKE %?2%) " +
            "AND (name LIKE %?3% " +
            "OR surname LIKE %?3% " +
            "OR budget LIKE %?3% " +
            "OR status LIKE %?3% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?3%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?3%))) " +
            "LIMIT ?4 OFFSET ?5",
            nativeQuery = true)
    List<StudentsEntity> findAllByFilterAndSearchLimit(String filterBudget, String filterStatus, String search, int limit, int offset);

    @Query(value = "SELECT count(*) FROM practicemanager.students where " +
            "(budget LIKE %?1% " +
            "AND status LIKE %?2%) " +
            "AND (name LIKE %?3% " +
            "OR surname LIKE %?3% " +
            "OR budget LIKE %?3% " +
            "OR status LIKE %?3% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?3%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?3%))) ",
            nativeQuery = true)
    int countAllByFilterAndSearch(String filterBudget, String filterStatus, String search);
    /////////////////////////////////////////////////////////////////////


    //Filter, Search and Sort order by surname
    @Query(value = "SELECT count(*) FROM practicemanager.students where " +
            "(budget LIKE %?1% " +
            "AND status LIKE %?2%) " +
            "AND (name LIKE %?3% " +
            "OR surname LIKE %?3% " +
            "OR budget LIKE %?3% " +
            "OR status LIKE %?3% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?3%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?3%))) " +
            "ORDER BY surname ASC",
            nativeQuery = true)
    int countAllByFilterAndSearchOrderBySurnameAsc(String filterBudget, String filterStatus, String search);

    @Query(value = "SELECT * FROM practicemanager.students where " +
            "(budget LIKE %?1% " +
            "AND status LIKE %?2%) " +
            "AND (name LIKE %?3% " +
            "OR surname LIKE %?3% " +
            "OR budget LIKE %?3% " +
            "OR status LIKE %?3% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?3%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?3%))) " +
            "ORDER BY surname ASC " +
            "LIMIT ?4 OFFSET ?5",
            nativeQuery = true)
    List<StudentsEntity> findAllByFilterAndSearchOrderBySurnameAscLimit(String filterBudget, String filterStatus, String search, int limit, int offset);

    @Query(value = "SELECT count(*) FROM practicemanager.students where " +
            "(budget LIKE %?1% " +
            "AND status LIKE %?2%) " +
            "AND (name LIKE %?3% " +
            "OR surname LIKE %?3% " +
            "OR budget LIKE %?3% " +
            "OR status LIKE %?3% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?3%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?3%))) " +
            "ORDER BY surname DESC",
            nativeQuery = true)
    int countAllByFilterAndSearchOrderBySurnameDesc(String filterBudget, String filterStatus, String search);

    @Query(value = "SELECT * FROM practicemanager.students where " +
            "(budget LIKE %?1% " +
            "AND status LIKE %?2%) " +
            "AND (name LIKE %?3% " +
            "OR surname LIKE %?3% " +
            "OR budget LIKE %?3% " +
            "OR status LIKE %?3% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?3%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?3%))) " +
            "ORDER BY surname DESC " +
            "LIMIT ?4 OFFSET ?5",
            nativeQuery = true)
    List<StudentsEntity> findAllByFilterAndSearchOrderBySurnameDescLimit(String filterBudget, String filterStatus, String search, int limit, int offset);
    ////////////////////////////////////////////////////////


    //Filter, Search and Sort order by average mark
    @Query(value = "SELECT count(*) FROM practicemanager.students where " +
            "(budget LIKE %?1% " +
            "AND status LIKE %?2%) " +
            "AND (name LIKE %?3% " +
            "OR surname LIKE %?3% " +
            "OR budget LIKE %?3% " +
            "OR status LIKE %?3% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?3%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?3%))) " +
            "ORDER BY avr_mark ASC",
            nativeQuery = true)
    int countAllByFilterAndSearchOrderByAvrMarkAsc(String filterBudget, String filterStatus, String search);

    @Query(value = "SELECT * FROM practicemanager.students where " +
            "(budget LIKE %?1% " +
            "AND status LIKE %?2%) " +
            "AND (name LIKE %?3% " +
            "OR surname LIKE %?3% " +
            "OR budget LIKE %?3% " +
            "OR status LIKE %?3% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?3%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?3%))) " +
            "ORDER BY avr_mark ASC " +
            "LIMIT ?4 OFFSET ?5",
            nativeQuery = true)
    List<StudentsEntity> findAllByFilterAndSearchOrderByAvrMarkAscLimit(String filterBudget, String filterStatus, String search, int limit, int offset);

    @Query(value = "SELECT count(*) FROM practicemanager.students where " +
            "(budget LIKE %?1% " +
            "AND status LIKE %?2%) " +
            "AND (name LIKE %?3% " +
            "OR surname LIKE %?3% " +
            "OR budget LIKE %?3% " +
            "OR status LIKE %?3% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?3%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?3%))) " +
            "ORDER BY avr_mark DESC",
            nativeQuery = true)
    int countAllByFilterAndSearchOrderByAvrMarkDesc(String filterBudget, String filterStatus, String search);

    @Query(value = "SELECT * FROM practicemanager.students where " +
            "(budget LIKE %?1% " +
            "AND status LIKE %?2%) " +
            "AND (name LIKE %?3% " +
            "OR surname LIKE %?3% " +
            "OR budget LIKE %?3% " +
            "OR status LIKE %?3% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?3%) " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?3%))) " +
            "ORDER BY avr_mark DESC " +
            "LIMIT ?4 OFFSET ?5",
            nativeQuery = true)
    List<StudentsEntity> findAllByFilterAndSearchOrderByAvrMarkDescLimit(String filterBudget, String filterStatus, String search, int limit, int offset);
    /////////////////////////////////////////////////////



}
