
package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("/api/users")
    @ResponseBody
    public List<Map<String, Object>> getUsers() {
        List<Map<String, Object>> users = new ArrayList<>();
        
        users.add(Map.of(
            "name", "John Doe",
            "age", 30,
            "city", "New York"));
        users.add(Map.of(
            "name", "Jane Doe",
            "age", 25,
            "city", "Los Angeles"));
        return users;
    }
}