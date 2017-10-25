/*
 This software is the confidential information and copyrighted work of
 NetCracker Technology Corp. ("NetCracker") and/or its suppliers and
 is only distributed under the terms of a separate license agreement
 with NetCracker.
 Use of the software is governed by the terms of the license agreement.
 Any use of this software not in accordance with the license agreement
 is expressly prohibited by law, and may result in severe civil
 and criminal penalties. 
 
 Copyright (c) 1995-2017 NetCracker Technology Corp.
 
 All Rights Reserved.
 
*/
/*
 * Copyright 1995-2017 by NetCracker Technology Corp.,
 * University Office Park III
 * 95 Sawyer Road
 * Waltham, MA 02453
 * United States of America
 * All rights reserved.
 */
package com.netcracker.etalon.controllers;

import com.netcracker.etalon.beans.UserViewModel;
import com.netcracker.pmbackend.impl.entities.SpecialityEntity;
import com.netcracker.pmbackend.impl.entities.StudentsEntity;
import com.netcracker.pmbackend.impl.entities.UsersEntity;
import com.netcracker.pmbackend.interfaces.SpecialityService;
import com.netcracker.pmbackend.interfaces.StudentsService;
import com.netcracker.pmbackend.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anpi0316
 *         Date: 06.10.2017
 *         Time: 14:04
 */
@Controller
public class TestController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private SpecialityService specialityService;

    @Autowired
    private ConversionService conversionService;


    // Type Descriptors for custom converters
    private final TypeDescriptor userEntityTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UsersEntity.class));
    private final TypeDescriptor userViewModelTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserViewModel.class));

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String goToLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/authorization", method = RequestMethod.GET)
    public String goToAuthorizationPage() {
        return "authorization";
    }

    // Spring Data Testing
    @RequestMapping(value = "/testdb", method = RequestMethod.GET)
    public String goTest() {

        UsersEntity usersEntity = usersService.findById(1);
        System.out.println(usersEntity.getId()+" "+ usersEntity.getLogin() + " "+ usersEntity.getPassword());

        for(StudentsEntity studentsEntity : studentsService.findAll()){
            System.out.println(studentsEntity.getId() + " " + studentsEntity.getName() + " " + studentsEntity.getSpecialityBySpecialityId().getName());
        }

        SpecialityEntity specialityEntity = specialityService.findById(1);
        System.out.println(specialityEntity.getId()+" "+ specialityEntity.getName() + specialityEntity.getFacultyByFacultyId().getName());

        return "login";
    }

    @RequestMapping(value = "/users-view", method = RequestMethod.GET)
    public ModelAndView getUsersAsModelWithView() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        //modelAndView.addObject("users", getStubUsers());
        return modelAndView;
    }


    @RequestMapping(value = "/usersAsJson", method = RequestMethod.GET)
    @ResponseBody
    public List<UserViewModel> getUsersAsJson() {
        List<UsersEntity> allUsers = usersService.findAll();
        return (List<UserViewModel>) conversionService.convert(allUsers,userEntityTypeDescriptor, userViewModelTypeDescriptor);
    }




}
/*
 WITHOUT LIMITING THE FOREGOING, COPYING, REPRODUCTION, REDISTRIBUTION,
 REVERSE ENGINEERING, DISASSEMBLY, DECOMPILATION OR MODIFICATION
 OF THE SOFTWARE IS EXPRESSLY PROHIBITED, UNLESS SUCH COPYING,
 REPRODUCTION, REDISTRIBUTION, REVERSE ENGINEERING, DISASSEMBLY,
 DECOMPILATION OR MODIFICATION IS EXPRESSLY PERMITTED BY THE LICENSE
 AGREEMENT WITH NETCRACKER. 
 
 THIS SOFTWARE IS WARRANTED, IF AT ALL, ONLY AS EXPRESSLY PROVIDED IN
 THE TERMS OF THE LICENSE AGREEMENT, EXCEPT AS WARRANTED IN THE
 LICENSE AGREEMENT, NETCRACKER HEREBY DISCLAIMS ALL WARRANTIES AND
 CONDITIONS WITH REGARD TO THE SOFTWARE, WHETHER EXPRESS, IMPLIED
 OR STATUTORY, INCLUDING WITHOUT LIMITATION ALL WARRANTIES AND
 CONDITIONS OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE,
 TITLE AND NON-INFRINGEMENT.
 
 Copyright (c) 1995-2017 NetCracker Technology Corp.
 
 All Rights Reserved.
*/