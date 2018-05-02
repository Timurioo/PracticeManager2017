package com.chekh.pmfrontend.controllers;

import com.chekh.pmbackend.interfaces.basic.PracticesService;
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
public class PracticeDataControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PracticesService practicesService;

    @Mock
    private ConversionService conversionService;

    @InjectMocks
    private PracticeDataController practiceDataController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(practiceDataController)
                .build();
    }

    @Test
    public void getPracticeData() {
    }

    @Test
    public void getPracticeData1() {
    }

    @Test
    public void getPracticesRequests() {
    }

    @Test
    public void getPracticeDataByCurator() {
    }
}