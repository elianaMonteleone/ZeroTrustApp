package com.zeroTrustApp.ZeroTrustApp.controller;

import com.zeroTrustApp.ZeroTrustApp.model.User;
import com.zeroTrustApp.ZeroTrustApp.service.UserServiceNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class RegisterController {

    @Autowired
    private UserServiceNew userService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // If there are form errors, return to the registration form and display them.
            return "register";
        }
        try {
            userService.registerNewUserAccount(user);
            // After successful registration, redirect to the login page.
            return "redirect:/login";
        } catch (Exception e) {
            // If an exception occurs, for example, the email already exists,
            // then add an error message to the model and return to the registration form.
            model.addAttribute("registrationError", e.getMessage());
            return "register";
        }
    }
}
