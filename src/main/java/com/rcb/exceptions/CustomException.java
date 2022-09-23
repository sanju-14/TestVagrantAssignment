package com.rcb.exceptions;


/**
 * September 24, 2022
 * @author Sanjay Kumar Gond
 * @version 1.0
 */
public final class CustomException extends RuntimeException{


    /**
     * Private constructor to avoid external instantiation
     */
    private CustomException(){

    }

    /**
     * Pass the message that needs to be appended to the stacktrace
     * @param message Details about the exception or custom message
     */
    public CustomException(String message) {
        super(message);
    }

}
