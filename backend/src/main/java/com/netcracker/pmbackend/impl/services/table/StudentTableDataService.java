package com.netcracker.pmbackend.impl.services.table;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netcracker.pmbackend.impl.entities.FilterData;
import com.netcracker.pmbackend.impl.entities.StudentTableData;
import com.netcracker.pmbackend.interfaces.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.io.IOException;

/**
 * Created by dima on 11/29/2017.
 */
@Service
public class StudentTableDataService {

    @Autowired
    private StudentsService studentsService;

    public StudentTableData getActualTableData(String search, String filter, String sort, String order, int limit, int offset) {

        if(!StringUtils.isEmpty(filter)) {

            if(!StringUtils.isEmpty(search)){

                if(!StringUtils.isEmpty(sort)){
                    return findFilterAndSearchAndSortData(filter, search, sort, order, limit, offset);
                }else {
                    return findFilterAndSearchData(filter, search, limit, offset);
                }

            }else if(!StringUtils.isEmpty(sort)) {
                return findFilterAndSortData(filter, sort, order, limit, offset);
            }else{
                return findFilterData(filter, limit, offset);
            }

        }else if(!StringUtils.isEmpty(search)) {

            if(!StringUtils.isEmpty(sort)) {
                return findSearchAndSortData(search, sort, order, limit, offset);
            } else {
                return findSearchData(search, limit, offset);
            }

        } else if(!StringUtils.isEmpty(sort)) {
            return findSortData(sort, order, limit, offset);

        } else {
            return findAllData(limit, offset);
        }
    }

    private StudentTableData findAllData(int limit, int offset) {
        StudentTableData studentTableData = new StudentTableData();
        studentTableData.setRowsData(studentsService.findAllLimit(limit, offset));
        studentTableData.setTotalRows((int) studentsService.countAll());
        return studentTableData;
    }

    private StudentTableData findSearchData(String search, int limit, int offset) {
        StudentTableData studentTableData = new StudentTableData();
        studentTableData.setRowsData(studentsService.findAllLimitSearch(search, limit, offset));
        studentTableData.setTotalRows(studentsService.countAllSearch(search));
        return studentTableData;
    }

    private StudentTableData findSortData(String sort, String order, int limit, int offset) {

        if (order.equals("asc")) {
            switch (sort) {
                case "surname": {
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllOrderBySurnameAscLimit(limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllOrderBySurnameAsc());
                    return studentTableData;
                }
                case "avrMark": {
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllOrderByAvrMarkAscLimit(limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllOrderByAvrMarkAsc());
                    return studentTableData;
                }
            }
        } else {
            switch (sort) {
                case "surname": {
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllOrderBySurnameDescLimit(limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllOrderBySurnameDesc());
                    return studentTableData;
                }
                case "avrMark": {
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllOrderByAvrMarkDescLimit(limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllOrderByAvrMarkDesc());
                    return studentTableData;
                }
            }
        }
        return null;
    }

    private StudentTableData findSearchAndSortData(String search, String sort, String order, int limit, int offset) {

        if (order.equals("asc")) {
            switch (sort) {
                case "surname": {
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllSearchOrderBySurnameAscLimit(search, limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllSearchOrderBySurnameAsc(search));
                    return studentTableData;
                }
                case "avrMark": {
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllSearchOrderByAvrMarkAscLimit(search, limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllSearchOrderByAvrMarkAsc(search));
                    return studentTableData;
                }
            }
        } else {
            switch (sort) {
                case "surname": {
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllSearchOrderBySurnameDescLimit(search, limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllSearchOrderBySurnameDesc(search));
                    return studentTableData;
                }
                case "avrMark": {
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllSearchOrderByAvrMarkDescLimit(search, limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllSearchOrderByAvrMarkDesc(search));
                    return studentTableData;
                }
            }
        }
        return null;
    }

    private StudentTableData findFilterData(String filterJson, int limit, int offset){
        FilterData filterData =convertFilterJsonToFilterData(filterJson);
        StudentTableData studentTableData = new StudentTableData();
        String filterBudget = filterData.getBudget()==null? "" : filterData.getBudget();
        String filterStatus = filterData.getStatus()==null? "" : filterData.getStatus();
        studentTableData.setRowsData(studentsService.findAllByFilterLimit(filterBudget, filterStatus, limit, offset));
        studentTableData.setTotalRows(studentsService.countAllByFilter(filterBudget, filterStatus));
        return studentTableData;
    }

    private StudentTableData findFilterAndSortData(String filterJson, String sort, String order, int limit, int offset){
        FilterData filterData =convertFilterJsonToFilterData(filterJson);
        String filterBudget = filterData.getBudget()==null? "" : filterData.getBudget();
        String filterStatus = filterData.getStatus()==null? "" : filterData.getStatus();

        if (order.equals("asc")) {
            switch (sort) {
                case "surname": {
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllByFilterOrderBySurnameAscLimit(filterBudget, filterStatus, limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllByFilterOrderBySurnameAsc(filterBudget, filterStatus));
                    return studentTableData;
                }
                case "avrMark": {
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllByFilterOrderByAvrMarkAscLimit(filterBudget, filterStatus, limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllByFilterOrderByAvrMarkAsc(filterBudget, filterStatus));
                    return studentTableData;
                }
            }
        } else {
            switch (sort) {
                case "surname": {
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllByFilterOrderBySurnameDescLimit(filterBudget, filterStatus, limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllByFilterOrderBySurnameDesc(filterBudget, filterStatus));
                    return studentTableData;
                }
                case "avrMark": {
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllByFilterOrderByAvrMarkDescLimit(filterBudget, filterStatus, limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllByFilterOrderByAvrMarkDesc(filterBudget, filterStatus));
                    return studentTableData;
                }
            }
        }
        return null;
    }

    private StudentTableData findFilterAndSearchData(String filterJson, String search, int limit, int offset){
        FilterData filterData =convertFilterJsonToFilterData(filterJson);
        String filterBudget = filterData.getBudget()==null? "" : filterData.getBudget();
        String filterStatus = filterData.getStatus()==null? "" : filterData.getStatus();
        StudentTableData studentTableData = new StudentTableData();
        studentTableData.setRowsData(studentsService.findAllByFilterAndSearchLimit(filterBudget, filterStatus, search, limit, offset));
        studentTableData.setTotalRows(studentsService.countAllByFilterAndSearch(filterBudget, filterStatus, search));
        return studentTableData;
    }

    private StudentTableData findFilterAndSearchAndSortData(String filterJson, String search, String sort, String order, int limit, int offset){
        FilterData filterData =convertFilterJsonToFilterData(filterJson);
        String filterBudget = filterData.getBudget()==null? "" : filterData.getBudget();
        String filterStatus = filterData.getStatus()==null? "" : filterData.getStatus();
        if (order.equals("asc")) {
            switch (sort) {
                case "surname": {
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllByFilterAndSearchOrderBySurnameAscLimit(filterBudget, filterStatus, search, limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllByFilterAndSearchOrderBySurnameAsc(filterBudget, filterStatus, search));
                    return studentTableData;
                }
                case "avrMark": {
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllByFilterAndSearchOrderByAvrMarkAscLimit(filterBudget, filterStatus, search, limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllByFilterAndSearchOrderByAvrMarkAsc(filterBudget, filterStatus, search));
                    return studentTableData;
                }
            }
        } else {
            switch (sort) {
                case "surname": {
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllByFilterAndSearchOrderBySurnameDescLimit(filterBudget, filterStatus, search, limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllByFilterAndSearchOrderBySurnameDesc(filterBudget, filterStatus, search));
                    return studentTableData;
                }
                case "avrMark": {
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllByFilterAndSearchOrderByAvrMarkDescLimit(filterBudget, filterStatus, search, limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllByFilterAndSearchOrderByAvrMarkDesc(filterBudget, filterStatus, search));
                    return studentTableData;
                }
            }
        }
        return null;
    }

    private FilterData convertFilterJsonToFilterData(String filterJson){
        ObjectMapper objectMapper = new ObjectMapper();
        FilterData filterData=null;
        try {
            filterData = objectMapper.readValue(filterJson, FilterData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filterData;
    }

}
