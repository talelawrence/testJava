package com.example.demo.conotroller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @GetMapping("/user")
    public String userForm(Model model) {
        model.addAttribute("user", new User());
        return "UserForm";
    }

    @PostMapping("/addUser")
    public String userSubmit(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "UserResult";
    }
}
