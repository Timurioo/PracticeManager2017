package com.chekh.pmfrontend.validation.converter;

import org.springframework.stereotype.Component;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dima on 11/8/2017.
 */
@Component
public class ValidationResponseDataConverter {

    public Map<String,String> convertFieldErrorsToMap(List<FieldError> fieldErrorsList){

        Map<String,String> resultMap = new HashMap<>();
        for (FieldError error : fieldErrorsList) {
            resultMap.put(error.getField(),error.getCode());
        }
        return resultMap;
    }

}
