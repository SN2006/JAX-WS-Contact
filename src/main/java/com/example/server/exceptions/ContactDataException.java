package com.example.server.exceptions;

import java.util.Map;

public class ContactDataException extends Exception{

    public ContactDataException(String message) {
        super(message);
    }

    public String getErrors(Map<String, String> errors){
        StringBuilder builder = new StringBuilder("\n");
        errors.forEach((field, error) ->
            builder.append(">> ").append(field).append(": ").append(error).append("\n")
        );
        return builder.toString();
    }
}
