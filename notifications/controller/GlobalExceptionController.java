package com.twilio.notifications.controller;

import com.twilio.notifications.domain.Administrator;
import com.twilio.notifications.domain.twilio.Client;
import com.twilio.notifications.service.AdministratorService;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@SuppressWarnings("UnusedDeclaration")
public class GlobalExceptionController {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String handleAllException(Exception ex) {
        String message = customMessage(ex.getMessage());
        String mediaUrl = "http://goo.gl/ObTXdX";

        // Send a message to the administrators when something goes unexpectedly wrong.
        Administrator[] administrators = new AdministratorService().getAdministrators();
        for (Administrator administrator : administrators) {
            new Client().sendMessage(administrator.getPhoneNumber(), message, mediaUrl);
        }

        return "Something unexpected happened. Keep calm, administrators were notified.";
    }

    private String customMessage(String exceptionMessage) {
        return String.format("It appears the server is having Exception: %s " +
                        "Go to: http://newrelic.com for more details. " +
                        "Image URL: http://goo.gl/ObTXdX",
                        exceptionMessage);
    }
}
