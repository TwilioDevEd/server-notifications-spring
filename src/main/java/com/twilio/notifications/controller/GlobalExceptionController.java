package com.twilio.notifications.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@SuppressWarnings("UnusedDeclaration")
public class GlobalExceptionController {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleAllException(Exception ex) {
        return "Something unexpected happened. Keep calm, administrators were notified.";
    }

    private String customMessage(String exceptionMessage) {
        return String.format("It appears the server is having Exception: %s " +
                        "Go to: http://newrelic.com for more details. " +
                        "Image URL: http://goo.gl/ObTXdX",
                        exceptionMessage);
    }
}
