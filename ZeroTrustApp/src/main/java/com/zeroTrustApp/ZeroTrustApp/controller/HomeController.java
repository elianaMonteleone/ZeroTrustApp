package com.zeroTrustApp.ZeroTrustApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home() {
        return "home"; // Assuming you have a home.html or home.jsp in your templates or views directory
    }
}