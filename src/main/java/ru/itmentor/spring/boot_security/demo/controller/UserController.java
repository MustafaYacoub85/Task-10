package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itmentor.spring.boot_security.demo.service.UserService;
import ru.itmentor.spring.boot_security.demo.model.User;
import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String userInfo(Model model, Principal principal) {
        String login = principal.getName();
        User user = userService.findByLogin(login);
        model.addAttribute("user", user);
        return "catalog/user";
    }
}


