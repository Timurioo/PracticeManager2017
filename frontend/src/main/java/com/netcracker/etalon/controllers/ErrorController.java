package com.netcracker.etalon.controllers;

import org.springframework.stereotype.Controller;
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
        String errorMsg = "";
        int httpErrorCode = getErrorCode(httpRequest);

        switch (httpErrorCode) {
            case 400: {
                errorMsg = "Error Code: 400. Bad Request";
                break;
            }
            case 401: {
                errorMsg = "Error Code: 401. Unauthorized.";
                break;
            }
            case 404: {
                errorMsg = "Error Code: 404. Resource not found.";
                break;
            }
            case 403: {
                errorMsg = "Error Code: 403. Access denied.";
                break;
            }
            case 500: {
                errorMsg = "Error Code: 500. Internal Server Error";
                break;
            }
        }
        errorPage.addObject("errorMsg", errorMsg);
        return errorPage;
    }

    private int getErrorCode(HttpServletRequest httpRequest) {
        return (Integer) httpRequest
                .getAttribute("javax.servlet.error.status_code");
    }
}


