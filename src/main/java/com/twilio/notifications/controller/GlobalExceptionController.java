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
        return ex.getMessage();
    }
}
