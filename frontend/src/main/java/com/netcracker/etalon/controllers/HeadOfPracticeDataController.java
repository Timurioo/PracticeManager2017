package com.netcracker.etalon.controllers;


import com.netcracker.etalon.beans.FacultyViewModel;
import com.netcracker.etalon.beans.HeadOfPracticeViewModel;
import com.netcracker.pmbackend.impl.entities.FacultyEntity;
import com.netcracker.pmbackend.impl.entities.HeadofpracticesEntity;
import com.netcracker.pmbackend.interfaces.HeadofpracticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HeadOfPracticeDataController {


    @Autowired
    private HeadofpracticesService headofpracticesService;

    @Autowired
    private ConversionService conversionService;

    // HeadOfPractice type descriptors
    private final TypeDescriptor headOfPracticeEntityListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HeadofpracticesEntity.class));
    private final TypeDescriptor headOfPracticeViewModelListTypeDescriptor = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(HeadOfPracticeViewModel.class));


    @RequestMapping(value = "/headOfPractice", method = RequestMethod.GET)
    @ResponseBody
    public List<HeadOfPracticeViewModel> getHeadOfPractice() {
        List<HeadofpracticesEntity> allHeadsOfPractice = headofpracticesService.findAll();
        return (List<HeadOfPracticeViewModel>) conversionService.convert(allHeadsOfPractice,headOfPracticeEntityListTypeDescriptor,headOfPracticeViewModelListTypeDescriptor);
    }
}
