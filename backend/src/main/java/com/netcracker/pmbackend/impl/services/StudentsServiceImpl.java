package com.netcracker.pmbackend.impl.services;

import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import com.netcracker.pmbackend.interfaces.StudentsService;
import com.netcracker.pmbackend.repository.StudentsRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("jpaStudentsService")
@Transactional
public class StudentsServiceImpl implements StudentsService {

    @Autowired
    private StudentsRepository studentsRepository;

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAll() {
        return Lists.newArrayList(studentsRepository.findAll());
    }

    @Transactional(readOnly = true)
    public long countAll() {
        return  studentsRepository.count();
    }

    @Transactional(readOnly = true)
    public StudentsEntity findById(int id) {
        return studentsRepository.findOne(id);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findByName(String name) {
        return studentsRepository.findByName(name);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findByClassgroup(String classgroup) {
        return studentsRepository.findByClassgroup(classgroup);
    }

    @Transactional(readOnly = true)
    public StudentsEntity findByUserId(int userId) {
        return studentsRepository.findByUserId(userId);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findByStatus(String status) {
        return studentsRepository.findByStatus(status);
    }

    @Transactional(readOnly = true)
    public StudentsEntity findByEmail(String email) {
        return studentsRepository.findByEmail(email);
    }

    @Transactional(readOnly = true)
    public StudentsEntity findByPhone(String phone) {
        return studentsRepository.findByPhone(phone);
    }

    public StudentsEntity save(StudentsEntity entity) {
        return studentsRepository.save(entity);
    }

    public void delete(int id) {
        studentsRepository.delete(id);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllLimit(int limit, int offset) {
        return studentsRepository.findAllLimit(limit, offset);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllLimitSearch(String search, int limit, int offset) {
        return studentsRepository.findAllLimitSearch(search,limit,offset);
    }

    @Transactional(readOnly = true)
    public int countAllSearch(String search) {
        return studentsRepository.countAllSearch(search);
    }


    //Sort order by surname
    @Transactional(readOnly = true)
    public int countAllOrderBySurnameAsc() {
        return studentsRepository.countAllOrderBySurnameAsc();
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllOrderBySurnameAscLimit(int limit, int offset) {
        return studentsRepository.findAllOrderBySurnameAscLimit(limit, offset);
    }

    @Transactional(readOnly = true)
    public int countAllOrderBySurnameDesc() {
        return studentsRepository.countAllOrderBySurnameDesc();
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllOrderBySurnameDescLimit(int limit, int offset) {
        return studentsRepository.findAllOrderBySurnameDescLimit(limit, offset);
    }


    //Sort order by average mark
    @Transactional(readOnly = true)
    public int countAllOrderByAvrMarkAsc() {
        return studentsRepository.countAllOrderByAvrMarkAsc();
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllOrderByAvrMarkAscLimit(int limit, int offset) {
        return studentsRepository.findAllOrderByAvrMarkAscLimit(limit, offset);
    }

    @Transactional(readOnly = true)
    public int countAllOrderByAvrMarkDesc() {
        return studentsRepository.countAllOrderByAvrMarkDesc();
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllOrderByAvrMarkDescLimit(int limit, int offset) {
        return studentsRepository.findAllOrderByAvrMarkDescLimit(limit, offset);
    }


    //Search and Sort order by surname
    @Transactional(readOnly = true)
    public int countAllSearchOrderBySurnameAsc(String search){
        return studentsRepository.countAllSearchOrderBySurnameAsc(search);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllSearchOrderBySurnameAscLimit(String search, int limit, int offset){
        return studentsRepository.findAllSearchOrderBySurnameAscLimit(search, limit, offset);
    }

    @Transactional(readOnly = true)
    public int countAllSearchOrderBySurnameDesc(String search){
        return studentsRepository.countAllSearchOrderBySurnameDesc(search);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllSearchOrderBySurnameDescLimit(String search, int limit, int offset){
        return studentsRepository.findAllSearchOrderBySurnameDescLimit(search, limit, offset);
    }


    //Search and Sort order by average mark
    @Transactional(readOnly = true)
    public int countAllSearchOrderByAvrMarkAsc(String search){
        return studentsRepository.countAllSearchOrderByAvrMarkAsc(search);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllSearchOrderByAvrMarkAscLimit(String search, int limit, int offset){
        return studentsRepository.findAllSearchOrderByAvrMarkAscLimit(search, limit, offset);
    }

    @Transactional(readOnly = true)
    public int countAllSearchOrderByAvrMarkDesc(String search){
        return studentsRepository.countAllSearchOrderByAvrMarkDesc(search);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllSearchOrderByAvrMarkDescLimit(String search, int limit, int offset){
        return studentsRepository.findAllSearchOrderByAvrMarkDescLimit(search, limit, offset);
    }


    //Find by curator
    @Transactional(readOnly = true)
    public int countAllByCuratorId(int curatorId) {
        return studentsRepository.countAllByCuratorId(curatorId);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllByCuratorIdLimit(int curatorId, int limit, int offset) {
        return studentsRepository.findAllByCuratorIdLimit(curatorId, limit, offset);
    }


    //Search and Find by curator
    @Transactional(readOnly = true)
    public int countAllByCuratorIdSearch(int curatorId, String search) {
        return studentsRepository.countAllByCuratorIdSearch(curatorId, search);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllByCuratorIdSearchLimit(int curatorId, String search, int limit, int offset) {
        return studentsRepository.findAllByCuratorIdSearchLimit(curatorId, search, limit, offset);
    }


    //Filter for all data
    @Transactional(readOnly = true)
    public int countAllByFilter(String filterBudget, String filterStatus) {
        return studentsRepository.countAllByFilter(filterBudget, filterStatus);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllByFilterLimit(String filterBudget, String filterStatus, int limit, int offset) {
        return studentsRepository.findAllByFilterLimit(filterBudget, filterStatus, limit, offset);
    }


    //Filter and Sort order by surname
    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllByFilterOrderBySurnameAscLimit(String filterBudget, String filterStatus, int limit, int offset) {
        return studentsRepository.findAllByFilterOrderBySurnameAscLimit(filterBudget, filterStatus, limit, offset);
    }

    @Transactional(readOnly = true)
    public int countAllByFilterOrderBySurnameAsc(String filterBudget, String filterStatus) {
        return studentsRepository.countAllByFilterOrderBySurnameAsc(filterBudget, filterStatus);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllByFilterOrderBySurnameDescLimit(String filterBudget, String filterStatus, int limit, int offset) {
        return studentsRepository.findAllByFilterOrderBySurnameDescLimit(filterBudget, filterStatus, limit, offset);
    }

    @Transactional(readOnly = true)
    public int countAllByFilterOrderBySurnameDesc(String filterBudget, String filterStatus) {
        return studentsRepository.countAllByFilterOrderBySurnameDesc(filterBudget, filterStatus);
    }


    //Filter and Sort order by average mark
    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllByFilterOrderByAvrMarkAscLimit(String filterBudget, String filterStatus, int limit, int offset) {
        return studentsRepository.findAllByFilterOrderByAvrMarkAscLimit(filterBudget, filterStatus, limit, offset);
    }

    @Transactional(readOnly = true)
    public int countAllByFilterOrderByAvrMarkAsc(String filterBudget, String filterStatus) {
        return studentsRepository.countAllByFilterOrderByAvrMarkAsc(filterBudget, filterStatus);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllByFilterOrderByAvrMarkDescLimit(String filterBudget, String filterStatus, int limit, int offset) {
        return studentsRepository.findAllByFilterOrderByAvrMarkDescLimit(filterBudget, filterStatus, limit, offset);
    }

    @Transactional(readOnly = true)
    public int countAllByFilterOrderByAvrMarkDesc(String filterBudget, String filterStatus) {
        return studentsRepository.countAllByFilterOrderByAvrMarkDesc(filterBudget, filterStatus);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllByFilterAndSearchLimit(String filterBudget, String filterStatus, String search, int limit, int offset) {
        return studentsRepository.findAllByFilterAndSearchLimit(filterBudget, filterStatus, search, limit, offset);
    }

    @Transactional(readOnly = true)
    public int countAllByFilterAndSearch(String filterBudget, String filterStatus, String search) {
        return studentsRepository.countAllByFilterAndSearch(filterBudget, filterStatus, search);
    }


    //Filter, Search and Sort order by surname
    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllByFilterAndSearchOrderBySurnameAscLimit(String filterBudget, String filterStatus, String search, int limit, int offset) {
        return studentsRepository.findAllByFilterAndSearchOrderBySurnameAscLimit(filterBudget, filterStatus, search, limit, offset);
    }

    @Transactional(readOnly = true)
    public int countAllByFilterAndSearchOrderBySurnameAsc(String filterBudget, String filterStatus, String search) {
        return studentsRepository.countAllByFilterAndSearchOrderBySurnameAsc(filterBudget, filterStatus, search);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllByFilterAndSearchOrderBySurnameDescLimit(String filterBudget, String filterStatus, String search, int limit, int offset) {
        return studentsRepository.findAllByFilterAndSearchOrderBySurnameDescLimit(filterBudget, filterStatus, search, limit, offset);
    }

    @Transactional(readOnly = true)
    public int countAllByFilterAndSearchOrderBySurnameDesc(String filterBudget, String filterStatus, String search) {
        return studentsRepository.countAllByFilterAndSearchOrderBySurnameDesc(filterBudget, filterStatus, search);
    }


    //Filter, Search and Sort order by average mark
    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllByFilterAndSearchOrderByAvrMarkAscLimit(String filterBudget, String filterStatus, String search, int limit, int offset) {
        return studentsRepository.findAllByFilterAndSearchOrderByAvrMarkAscLimit(filterBudget, filterStatus, search, limit, offset);
    }

    @Transactional(readOnly = true)
    public int countAllByFilterAndSearchOrderByAvrMarkAsc(String filterBudget, String filterStatus, String search) {
        return studentsRepository.countAllByFilterAndSearchOrderByAvrMarkAsc(filterBudget, filterStatus, search);
    }

    @Transactional(readOnly = true)
    public List<StudentsEntity> findAllByFilterAndSearchOrderByAvrMarkDescLimit(String filterBudget, String filterStatus, String search, int limit, int offset) {
        return studentsRepository.findAllByFilterAndSearchOrderByAvrMarkDescLimit(filterBudget, filterStatus, search, limit, offset);
    }

    @Transactional(readOnly = true)
    public int countAllByFilterAndSearchOrderByAvrMarkDesc(String filterBudget, String filterStatus, String search) {
        return studentsRepository.countAllByFilterAndSearchOrderByAvrMarkDesc(filterBudget, filterStatus, search);
    }


}
