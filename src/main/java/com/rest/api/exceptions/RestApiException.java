package com.rest.api.exceptions;

/**
 * @author Reza Arshad
 */
public class RestApiException extends RuntimeException {

    public static final String FRUIT_NOT_FOUND_EXCEPTION = "Fruit not found!";

    public RestApiException(String message) {
        super(message);
    }
}
