package com.netcracker.etalon.resolver;

import com.netcracker.pmbackend.interfaces.HeadofpracticesService;
import com.netcracker.pmbackend.interfaces.StudentsService;
import com.netcracker.pmbackend.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

/**
 * Created by dima on 12/17/2017.
 */
@Component
public class CustomViewResolver {

    @Autowired
    private UsersService usersService;

    @Autowired
    private StudentsService studentsService;

    @Autowired
    private HeadofpracticesService headofpracticesService;

    public String resolveHomePageByRole(){
        User user;
        String urlRedirect = "redirect:/authorization";
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (ClassCastException e){
            return urlRedirect;
        }
        String userLogin = user.getUsername();
        String userRole = null;

        for (GrantedAuthority authority : user.getAuthorities()) {
            userRole = authority.getAuthority();
        }

        switch (userRole){
            case "ROLE_ADMIN":{
                urlRedirect = "redirect:/admin";
                break;
            }
            case "ROLE_STUDENT":{
                long studentId = studentsService.findByUserId(usersService.findByLogin(userLogin).getId()).getId();
                urlRedirect = "redirect:/studentProfile/" + studentId;
                break;
            }
            case "ROLE_HEADOFPRACTICE":{
                long curatorId = headofpracticesService.findByUserId(usersService.findByLogin(userLogin).getId()).getId();
                urlRedirect = "redirect:/curator/" + curatorId;
                break;
            }
        }

        return urlRedirect;
    }

    public String resolveStudentProfilePageById(int studentId){
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (ClassCastException e){
            return "redirect:/authorization";
        }
        String userLogin = user.getUsername();
        String userRole = null;

        for (GrantedAuthority authority : user.getAuthorities()) {
            userRole = authority.getAuthority();
        }

        if(userRole.equals("ROLE_STUDENT")) {
            long currentStudentId = studentsService.findByUserId(usersService.findByLogin(userLogin).getId()).getId();

            if (currentStudentId != studentId) {
                return "redirect:/errors/403";
            }
        }
        return "studentprofile";
    }

    public String resolveCuratorPageById(int curatorId){
        User user;
        try {
            user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }catch (ClassCastException e){
            return "redirect:/authorization";
        }
        String userLogin = user.getUsername();
        String userRole = null;

        for (GrantedAuthority authority : user.getAuthorities()) {
            userRole = authority.getAuthority();
        }

        if(userRole.equals("ROLE_HEADOFPRACTICE")) {
            long currentCuratorId = headofpracticesService.findByUserId(usersService.findByLogin(userLogin).getId()).getId();

            if (currentCuratorId != curatorId) {
                return "redirect:/errors/403";
            }
        }
        return "curator";
    }
}
