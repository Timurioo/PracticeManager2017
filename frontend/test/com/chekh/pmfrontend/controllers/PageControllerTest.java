package com.chekh.pmfrontend.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PageControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private PageController pageController;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(pageController)
                .build();
    }

    @Test
    public void redirectRoleToPage() {
    }

    @Test
    public void goToAuthorizationPage() {
    }

    @Test
    public void goToAdmin() {
    }

    @Test
    public void goToCuratorPage() {
    }

    @Test
    public void goToPractice() {
    }

    @Test
    public void goToStudentProfile() {
    }

    @Test
    public void registration() {
    }

    @Test
    public void registrationFaculty() {
    }

    @Test
    public void registrationPractice() {
    }
}