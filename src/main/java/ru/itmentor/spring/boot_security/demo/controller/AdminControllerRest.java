//package ru.itmentor.spring.boot_security.demo.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import ru.itmentor.spring.boot_security.demo.controller.payload.NewUserPayload;
//import ru.itmentor.spring.boot_security.demo.model.User;
//import ru.itmentor.spring.boot_security.demo.service.UserService;
//
//import java.util.Collections;
//import java.util.Iterator;
//import java.util.NoSuchElementException;
//
//
//@RestController
//@RequestMapping("/api")
//public class AdminControllerRest {
//    public final UserService userService;
//
//    public AdminControllerRest(UserService userService) {
//        this.userService = userService;
//    }
//
//
//    @GetMapping(value = "catalog/list") //список юзеров
//    public ResponseEntity<Iterable<User>> getUserList(Model model) {
//        return ResponseEntity.ok().body(userService.getAllUser());
//    }
//
//    @PostMapping("catalog/list/creat")
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        userService.saveUser(user);
//        return ResponseEntity.ok().body(user);
//    }
//
////    @GetMapping("catalog/list/creat") // возврашаем страницу с формой нового товара
////    public String getNewUser() {
////        return "catalog/new_list";
////    }
////
////    @PostMapping("catalog/list/creat") // обработка формы возврата товара
////    public String creatUser(NewUserPayload payload) {
////        User user = this.userService.creatUser(payload.age(), payload.email(), payload.firstName(), payload.lastName(), payload.password(), payload.login());
////        return "redirect:/catalog/list";
////    }
////
////    @GetMapping
////    public String getUser() {
////        return "catalog/edit";
////    }
////
////    @GetMapping("catalog/list/edit/{userId}")
////    public String getUserEditPage(@PathVariable("userId") Integer id, Model model) {
////        var user = userService.findUser(id);
////        User presentUser = null;
////        if (user.isPresent()) {
////            presentUser = user.get();
////        } else {
////            throw new NoSuchElementException("User is not found");
////        }
////        model.addAttribute("user", presentUser);
////
////        return "/catalog/edit";
////
////    }
////
////    @PostMapping("catalog/list/update/{userId}")
////    public String updateUser(User presentUser, @PathVariable Integer userId) {
////        userService.updateUser(presentUser);
////        return "redirect:/catalog/list";
////    }
////
////
////    @GetMapping("catalog/list/delete/{userId}")
////    public String deleteUser(@PathVariable("userId") Integer id) {
////        this.userService.deleteUser(id);
////        return "redirect:/catalog/list";
////
////    }
//
//
//}


