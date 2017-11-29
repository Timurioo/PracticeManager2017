package com.netcracker.pmbackend.interfaces;

import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import java.util.List;


public interface StudentsService {

    List<StudentsEntity> findAll();
    long countAll();
    StudentsEntity findById(int id);
    List<StudentsEntity> findByName(String name);
    List<StudentsEntity> findByClassgroup(String classgroup);
    StudentsEntity findByUserId(int userId);
    List<StudentsEntity> findByStatus(String status);
    StudentsEntity findByEmail(String email);
    StudentsEntity findByPhone(String phone);
    StudentsEntity save(StudentsEntity entity);
    void delete(int id);

    List<StudentsEntity> findAllLimit(int limit, int offset);
    List<StudentsEntity> findAllLimitSearch(String search, int limit, int offset );
    int countAllSearch(String search);

    //Sort order by surname
    List<StudentsEntity> findAllOrderBySurnameAscLimit(int limit, int offset);
    int countAllOrderBySurnameAsc();
    List<StudentsEntity> findAllOrderBySurnameDescLimit(int limit, int offset);
    int countAllOrderBySurnameDesc();

    //Sort order by average mark
    List<StudentsEntity> findAllOrderByAvrMarkAscLimit(int limit, int offset);
    int countAllOrderByAvrMarkAsc();
    List<StudentsEntity> findAllOrderByAvrMarkDescLimit(int limit, int offset);
    int countAllOrderByAvrMarkDesc();

    //Search and Sort order by surname
    List<StudentsEntity> findAllSearchOrderBySurnameAscLimit(String search, int limit, int offset);
    int countAllSearchOrderBySurnameAsc(String search);
    List<StudentsEntity> findAllSearchOrderBySurnameDescLimit(String search, int limit, int offset);
    int countAllSearchOrderBySurnameDesc(String search);

    //Search and Sort order by average mark
    List<StudentsEntity> findAllSearchOrderByAvrMarkAscLimit(String search, int limit, int offset);
    int countAllSearchOrderByAvrMarkAsc(String search);
    List<StudentsEntity> findAllSearchOrderByAvrMarkDescLimit(String search, int limit, int offset);
    int countAllSearchOrderByAvrMarkDesc(String search);

    //Find all by curator
    int countAllByCuratorId(int curatorId);
    List<StudentsEntity> findAllByCuratorIdLimit(int curatorId, int limit, int offset);

    //Search and Find by curator
    int countAllByCuratorIdSearch(int curatorId, String search);
    List<StudentsEntity> findAllByCuratorIdSearchLimit(int curatorId, String search, int limit, int offset);

}
