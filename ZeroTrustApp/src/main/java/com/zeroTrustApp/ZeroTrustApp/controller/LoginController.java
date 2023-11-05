package com.zeroTrustApp.ZeroTrustApp.controller;



import com.zeroTrustApp.ZeroTrustApp.service.UserServiceNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    private UserServiceNew userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String performLogin(@RequestParam String username, @RequestParam String password, Model model) {
        if (userService.authenticateUser(username, password)) {
            System.out.println("Authentication successful for user: " + username); // Log success
            return "redirect:/tickets";
        } else {
            System.out.println("Authentication failed for user: " + username); // Log failure
            model.addAttribute("loginError", "Invalid username or password");
            return "redirect:/home";
        }
    }
}
