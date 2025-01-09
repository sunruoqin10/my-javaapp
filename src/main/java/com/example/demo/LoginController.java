
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
        // Logic for handling login
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(@RequestParam String username, @RequestParam String password) {
        if (!username.isEmpty() && !password.isEmpty()) {
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            return "redirect:/welcome";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome";
    }
}