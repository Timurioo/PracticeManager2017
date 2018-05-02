package com.chekh.pmfrontend.controllers;

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
public class HeadOfPracticeDataControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private HeadOfPracticeDataController headOfPracticeDataController;

    @Mock
    private ConversionService conversionService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(headOfPracticeDataController)
                .build();
    }

    @Test
    public void getHeadOfPractice() {
    }

    @Test
    public void getHeadOfPracticeName() {
    }
}