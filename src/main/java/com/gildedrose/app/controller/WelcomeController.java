package com.gildedrose.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class WelcomeController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping(value = "/")
    public String index() {
        return "welcome";
    }
}

