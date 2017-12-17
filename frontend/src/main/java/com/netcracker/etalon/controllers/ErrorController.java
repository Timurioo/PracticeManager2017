package com.netcracker.etalon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by dima on 12/13/2017.
 */
@Controller
public class ErrorController {

    @RequestMapping(value = "/errors", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
        ModelAndView errorPage = new ModelAndView("errPage");
        int httpErrorCode = getErrorCode(httpRequest);
        String errorMsg = getErrorMsg(httpErrorCode);
        errorPage.addObject("errorMsg", errorMsg);
        return errorPage;
    }

    @RequestMapping(value = "/errors/{code}", method = RequestMethod.GET)
    public ModelAndView renderErrorPage(@PathVariable String code) {
        ModelAndView errorPage = new ModelAndView("errPage");
        int httpErrorCode = Integer.parseInt(code);
        String errorMsg = getErrorMsg(httpErrorCode);
        errorPage.addObject("errorMsg", errorMsg);
        return errorPage;
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }

    private String getErrorMsg(int code){
        switch (code) {
            case 400: {
                return "Error Code: 400. Bad Request";
            }
            case 401: {
                return "Error Code: 401. Unauthorized.";
            }
            case 404: {
                return "Error Code: 404. Resource not found.";
            }
            case 403: {
                return "Error Code: 403. Access denied.";
            }
            case 500: {
                return "Error Code: 500. Internal Server Error";
            }
            default:
                return "";
        }
    }
}


