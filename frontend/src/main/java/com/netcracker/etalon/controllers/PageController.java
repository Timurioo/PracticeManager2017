package com.netcracker.etalon.controllers;

import com.netcracker.etalon.resolver.CustomViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    @Autowired
    private CustomViewResolver customViewResolver;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String redirectRoleToPage() {
        return customViewResolver.resolveHomePageByRole();
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public String goToAuthorizationPage() {
        return "authorization";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String goToAdmin() {
        return "adminpage";
    }

    @RequestMapping(value = "/curator/{id}", method = RequestMethod.GET)
    public String goToCuratorPage(@PathVariable int id) {
        return customViewResolver.resolveCuratorPageById(id);
    }

    @RequestMapping(value = "/practicesRequests", method = RequestMethod.GET)
    public String goToPractice() {
        return "allRequests";
    }

    @RequestMapping(value = "/studentProfile/{id}", method = RequestMethod.GET)
    public String goToStudentProfile(@PathVariable int id) {
        return customViewResolver.resolveStudentProfilePageById(id);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }

    @RequestMapping(value = "/registration/faculty", method = RequestMethod.GET)
    public String registrationFaculty() {
        return "createFaculty";
    }

    @RequestMapping(value = "/registration/practice", method = RequestMethod.GET)
    public String registrationPractice() {
        return "createRequest";
    }

}