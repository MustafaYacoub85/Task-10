package ru.itmentor.spring.boot_security.demo.dao;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.itmentor.spring.boot_security.demo.model.User;

public interface UserDao extends CrudRepository<User, Integer> {
    User findByLogin(String login);

}
