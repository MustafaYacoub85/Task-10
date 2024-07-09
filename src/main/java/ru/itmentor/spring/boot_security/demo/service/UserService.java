package ru.itmentor.spring.boot_security.demo.service;


import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.util.Optional;
import java.util.Set;

public interface UserService {

//    User creatUser(User user);
    Iterable<User> getAllUser();
    User updateUser(User user);
    Optional<User> findUser(Integer userId);
    User creatUser(int age, String email, String firstName, String lastName, String password, String login);
    Optional<Role> findRole(Integer roleId);
    Iterable<Role> getAllRole();

    void deleteUser(Integer id);

    User findByLogin(String login);

//    void updateUser(Integer id, int age, String firstName, String lastName, String email);






}
