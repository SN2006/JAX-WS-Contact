package com.example.server.utils;

public class AppValidator {

    public final static String ID_RGX = "^[1-9][0-9]*$";
    public final static String PHONE_RGX = "[0-9]{3} [0-9]{3}-[0-9]{4}";

    public static boolean isValidId(String id) {
        if (id != null){
            return id.isEmpty() || !id.matches(ID_RGX);
        }
        return false;
    }

    public static boolean isPhoneValid(String phone) {
        if (phone != null)
            return phone.isEmpty() || !phone.matches(PHONE_RGX);
        return false;
    }

}
