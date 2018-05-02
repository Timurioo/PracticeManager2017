package com.chekh.pmfrontend.controllers;

import com.chekh.pmbackend.interfaces.basic.FacultyService;
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
public class FacultyDataControllerTest {

    private MockMvc mockMvc;

    @Mock
    private FacultyService facultyService;

    @Mock
    private ConversionService conversionService;

    @InjectMocks
    private FacultyDataController facultyDataController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(facultyDataController)
                .build();
    }

    @Test
    public void getFaculties() {
    }

    @Test
    public void getFacultyById() {
    }

    @Test
    public void getSpecialities() {
    }
}