package com.netcracker.pmbackend.impl.services.table;

import com.netcracker.pmbackend.impl.entities.StudentTableData;
import com.netcracker.pmbackend.interfaces.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dima on 11/29/2017.
 */
@Service
public class StudentTableDataService {

    @Autowired
    private StudentsService studentsService;

    public StudentTableData getActualTableData(String search, String sort, String order, int limit, int offset){

        if(!search.equals("")){

            if(!sort.equals("")){
                return findSearchAndSortData(search, sort, order, limit, offset);
            }else {
                return findSearchData(search, limit, offset);
            }

        }else if(!sort.equals("")){

            return findSortData(sort, order, limit, offset);

        }else{

            return findAllData(limit, offset);
        }
    }

    private StudentTableData findAllData(int limit, int offset){
        StudentTableData studentTableData = new StudentTableData();
        studentTableData.setRowsData(studentsService.findAllLimit(limit, offset));
        studentTableData.setTotalRows((int)studentsService.countAll());
        return studentTableData;
    }

    private StudentTableData findSearchData(String search, int limit, int offset){
        StudentTableData studentTableData = new StudentTableData();
        studentTableData.setRowsData(studentsService.findAllLimitSearch(search, limit, offset));
        studentTableData.setTotalRows(studentsService.countAllSearch(search));
        return studentTableData;
    }

    private StudentTableData findSortData(String sort, String order, int limit, int offset){

        if(order.equals("asc")){
            switch (sort){
                case "surname":{
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllOrderBySurnameAscLimit(limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllOrderBySurnameAsc());
                    return studentTableData;
                }
                case "avrMark":{
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllOrderByAvrMarkAscLimit(limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllOrderByAvrMarkAsc());
                    return studentTableData;
                }
            }
        }else{
            switch (sort){
                case "surname":{
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllOrderBySurnameDescLimit(limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllOrderBySurnameDesc());
                    return studentTableData;
                }
                case "avrMark":{
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllOrderByAvrMarkDescLimit(limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllOrderByAvrMarkDesc());
                    return studentTableData;
                }
            }
        }
        return null;
    }

    private StudentTableData findSearchAndSortData(String search, String sort, String order, int limit, int offset){

        if(order.equals("asc")){
            switch (sort){
                case "surname":{
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllSearchOrderBySurnameAscLimit(search, limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllSearchOrderBySurnameAsc(search));
                    return studentTableData;
                }
                case "avrMark":{
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllSearchOrderByAvrMarkAscLimit(search, limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllSearchOrderByAvrMarkAsc(search));
                    return studentTableData;
                }
            }
        }else{
            switch (sort){
                case "surname":{
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllSearchOrderBySurnameDescLimit(search, limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllSearchOrderBySurnameDesc(search));
                    return studentTableData;
                }
                case "avrMark":{
                    StudentTableData studentTableData = new StudentTableData();
                    studentTableData.setRowsData(studentsService.findAllSearchOrderByAvrMarkDescLimit(search, limit, offset));
                    studentTableData.setTotalRows(studentsService.countAllSearchOrderByAvrMarkDesc(search));
                    return studentTableData;
                }
            }
        }
        return null;
    }

}
