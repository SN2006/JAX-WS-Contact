package com.example.server.utils;

import java.util.HashMap;
import java.util.Map;

public class ContactValidator {

    public Map<String, String> validateIdNamePhone(String[] data) {
        Map<String, String> errors = new HashMap<>();

        if (data[0] != null & AppValidator.isValidId(data[0])) {
            errors.put("id", Constants.WRONG_ID_MSG);
        }

        if (data[1] != null){
            if (data[1].isEmpty()){
                errors.put("name", Constants.INPUT_REQ_MSG);
            }
        }

        if (data[2] != null &
                AppValidator.isPhoneValid(data[2])){
            errors.put("phone", Constants.WRONG_PHONE_MSG);
        }

        return errors;
    }

    public Map<String, String> validateNamePhone(String[] data) {
        Map<String, String> errors = new HashMap<>();

        if (data[0] != null){
            if (data[1].isEmpty()){
                errors.put("name", Constants.INPUT_REQ_MSG);
            }
        }

        if (data[1] != null &
                AppValidator.isPhoneValid(data[1])){
            errors.put("phone", Constants.WRONG_PHONE_MSG);
        }

        return errors;
    }

    public Map<String, String> validateId(String[] data) {
        Map<String, String> errors = new HashMap<>();

        if (data[0] != null & AppValidator.isValidId(data[0])) {
            errors.put("id", Constants.WRONG_ID_MSG);
        }

        return errors;
    }

}
