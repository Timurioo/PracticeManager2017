package com.netcracker.pmbackend.repository;

import com.netcracker.pmbackend.impl.entities.PracticesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PracticesRepository extends CrudRepository<PracticesEntity, Integer> {

    List<PracticesEntity> findByHeadofpracticeId(int headofpracticeId);
    List<PracticesEntity> findByStatus(String status);
    PracticesEntity findByCompany(String company);

    @Query(value ="SELECT * FROM practicemanager.practices LIMIT ?1 OFFSET ?2 " , nativeQuery = true)
    List<PracticesEntity> findAllLimit(int limit, int offset);

    @Query(value = "SELECT * FROM practicemanager.practices where company LIKE %?1% " +
            "OR status LIKE %?1% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?1%) " +
            "OR faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?1%) " +
            "OR headofpractice_id IN (SELECT id FROM practicemanager.headofpractices WHERE name LIKE %?1%)" +
            "LIMIT ?2 OFFSET ?3",
            nativeQuery = true)
    List<PracticesEntity> findAllLimitSearch(String search, int limit, int offset);

    @Query(value = "SELECT * FROM practicemanager.practices where company LIKE %?1% " +
            "OR status LIKE %?1% " +
            "OR speciality_id IN (SELECT id FROM practicemanager.speciality WHERE name LIKE %?1%) " +
            "OR faculty_id IN (SELECT id FROM practicemanager.faculty WHERE name LIKE %?1%) " +
            "OR headofpractice_id IN (SELECT id FROM practicemanager.headofpractices WHERE name LIKE %?1%)",
            nativeQuery = true)
    List<PracticesEntity> findAllSearch(String search);

}
