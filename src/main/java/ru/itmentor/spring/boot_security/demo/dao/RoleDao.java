package ru.itmentor.spring.boot_security.demo.dao;

import org.springframework.data.repository.CrudRepository;
import ru.itmentor.spring.boot_security.demo.model.Role;


public interface RoleDao extends CrudRepository<Role, Integer> {
}

