package com.chekh.pmbackend.interfaces.assign;

import java.util.List;

/**
 * Created by dima on 12/20/2017.
 */
public interface AssignService {
    void assignStudents(int practiceId, List<Integer> studentsIds);
}
