package ru.itmentor.spring.boot_security.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;
import ru.itmentor.spring.boot_security.demo.controller.payload.*;

@Controller
@RequiredArgsConstructor

public class AdminController {
    public final UserService userService;


    @GetMapping(value = "catalog/list") //список юзеров
    public String getUserList(Model model) {
        model.addAttribute("users", this.userService.getAllUser());
        return "catalog/list";
    }

    @GetMapping("catalog/list/creat")
    public String getNewUser() {
        return "catalog/new_list";
    }

    @PostMapping("catalog/list/creat") //
    public String creatUser(NewUserPayload payload) {
        User user = this.userService.creatUser(payload.age(), payload.email(), payload.firstName(), payload.lastName(), payload.password(), payload.login());
        return "redirect:/catalog/list";
    }


}
