package com.chekh.pmfrontend.controllers;

import com.chekh.pmbackend.interfaces.basic.SpecialityService;
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
public class SpecialityDataControllerTest {

    private MockMvc mockMvc;

    @Mock
    private SpecialityService specialityService;

    @Mock
    private ConversionService conversionService;

    @InjectMocks
    private SpecialityDataController specialityDataController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(specialityDataController)
                .build();
    }

    @Test
    public void getSpecialities() {
    }

    @Test
    public void getSpecialityById() {
    }
}