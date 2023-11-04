package com.zeroTrustApp.ZeroTrustApp.controller;



import com.zeroTrustApp.ZeroTrustApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

   /* @PostMapping("/login")
    public String login(String username, String lastname) {
        if (userService.login(username, lastname)) {
            return "redirect:/welcome"; // Redirect to a welcome page after successful login.
        } else {
            return "login"; // Redirect to the login page with an error message.
        }
    }*/
}
