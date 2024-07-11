package ru.itmentor.spring.boot_security.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itmentor.spring.boot_security.demo.controller.payload.NewUserPayload;
import ru.itmentor.spring.boot_security.demo.model.User;
import ru.itmentor.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.Optional;


@RestController
@RequestMapping()
public class ControllerRest {
    public final UserService userService;

    public ControllerRest(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("catalog/list/api") //список юзеров
    public ResponseEntity<Iterable<User>> getUserList(Model model) {
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    @GetMapping("catalog/list/api/{userId}") //возвращаем одного пользователя
    public User getUser(@PathVariable Integer userId) {
        Optional<User> user = userService.findUser(userId);
        return user.orElse(null);
    }

    @DeleteMapping("/catalog/list/api/{userId}") // удаляет юзера
    public void deleteUser(@PathVariable("userId") Integer id) {
        this.userService.deleteUser(id);

    }

    @PostMapping("/catalog/list/api/creat")  //создает нового юзера
    public User creatUser(NewUserPayload payload) {

        User user = this.userService.creatUser(payload.age(), payload.email(), payload.firstName(), payload.lastName(), payload.password(), payload.login());
        return user;
    }

    @PutMapping("catalog/list/api/{userId}") //изменяет юзера
    public User updaetUser(User user, @PathVariable Integer userId) {
        userService.updateUser(user);
        return user;
    }


    @GetMapping("/user/api")
    public User userInfo(Model model, Principal principal) {
        String login = principal.getName();
        User user = userService.findByLogin(login);
        model.addAttribute("user", user);
        return user;
    }
}

