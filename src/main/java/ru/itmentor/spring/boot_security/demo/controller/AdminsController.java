package ru.itmentor.spring.boot_security.demo.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;

import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
public class AdminsController {
    public final UserService userService;

    @GetMapping
    public String getUser() {
        return "catalog/edit";
    }

    @GetMapping("catalog/list/edit/{userId}")
    public String getUserEditPage(@PathVariable("userId") Integer id, Model model) {
        var user = userService.findUser(id);
        User presentUser = null;
        if (user.isPresent()) {
            presentUser = user.get();
        } else {
            throw new NoSuchElementException("User is not found");
        }
        model.addAttribute("user", presentUser);

        return "/catalog/edit";

    }

    @PostMapping("catalog/list/update/{userId}")
    public String updateUser(User presentUser, @PathVariable Integer userId) {
        userService.updateUser(presentUser);
        return "redirect:/catalog/list";
    }



    @GetMapping("catalog/list/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Integer id) {
        this.userService.deleteUser(id);
        return "redirect:/catalog/list";

    }

}
