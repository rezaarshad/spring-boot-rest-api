package com.rest.api.exceptions;

import java.util.Date;

/**
 * @author Reza Arshad
 */
public class ExceptionResponse {
    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse() {
    }

    public ExceptionResponse(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

}