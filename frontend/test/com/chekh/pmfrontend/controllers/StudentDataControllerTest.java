package com.chekh.pmfrontend.controllers;

import com.chekh.pmbackend.interfaces.basic.FacultyService;
import com.chekh.pmbackend.interfaces.basic.StudentsService;
import com.chekh.pmbackend.interfaces.table.StudentTableDataService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentDataControllerTest {

    private MockMvc mockMvc;

    @Mock
    private StudentTableDataService studentTableDataService;

    @Mock
    private StudentsService studentsService;

    @Mock
    private ConversionService conversionService;

    @InjectMocks
    private StudentDataController studentDataController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(studentDataController)
                .build();
    }

    @Test
    public void getStudentProfileData() {
    }

    @Test
    public void getStudentsAndPractice() {
    }

    @Test
    public void getStudentsAndPracticeDataByCurator() {
    }
}