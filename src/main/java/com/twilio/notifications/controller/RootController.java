package com.twilio.notifications.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SuppressWarnings("UnusedDeclaration")
public class RootController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String index() throws Exception {
        throw new Exception("Impossible just happened");
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    @ResponseBody
    public void error(HttpServletRequest request, HttpServletResponse response)throws Exception {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Something went wrong!</h1>");
        response.getWriter().println("<h2>Our Engineers are on it</h2>");
        response.getWriter().println("<a href='/'>Go Home</a>");
    }

}
