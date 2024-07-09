package ru.itmentor.spring.boot_security.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import ru.itmentor.spring.boot_security.demo.dao.RoleDao;
import ru.itmentor.spring.boot_security.demo.dao.UserDao;
import ru.itmentor.spring.boot_security.demo.model.Role;
import ru.itmentor.spring.boot_security.demo.model.User;

import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserDao userDao;
    private final RoleDao roleDao;


    @Override
    public Iterable<User> getAllUser() {
        return this.userDao.findAll();
    }

    @Override
    public Iterable<Role> getAllRole() {
        return this.roleDao.findAll();
    }




    @Override
    public Optional<User> findUser(Integer userId) {
        return this.userDao.findById(userId);
    }

    @Override
    public User creatUser(int age, String email, String firstName, String lastName, String password, String login) {
        return this.userDao.save(new User(age, email, firstName, lastName, password, login));
    }


    @Override
    public Optional<Role> findRole(Integer roleId) {
        return this.roleDao.findById(roleId);
    }

//    @Override
//    public void updateUser(Integer id, int age, String firstName, String lastName, String email) {
//        this.userDao.findById(id).ifPresentOrElse(user -> {
//            user.setAge(age);
//            user.setFirstName(firstName);
//            user.setLastName(lastName);
//            user.setEmail(email);
//        }, () -> {
//            throw new NoSuchElementException();
//        });
//    }

    @Override
    public void deleteUser(Integer id) {
        this.userDao.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        Optional<User> optionalUpdatingUser = userDao.findById(user.getId());
        if (optionalUpdatingUser.isPresent()) {
            User updatingUser = optionalUpdatingUser.get();
            updatingUser.setAge(user.getAge());
            updatingUser.setFirstName(user.getFirstName());
            updatingUser.setLastName(user.getLastName());
            updatingUser.setEmail(user.getEmail());
            return userDao.save(updatingUser);
        } else {
            throw new NullPointerException("User is null");
        }
    }

    public User findByLogin(String login) {
        return userDao.findByLogin(login);
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = this.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", login));
        }
         return  user;
    }
}







