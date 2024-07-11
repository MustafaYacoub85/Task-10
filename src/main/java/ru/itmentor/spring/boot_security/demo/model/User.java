package ru.itmentor.spring.boot_security.demo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "table_user")
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "password")
    private String password;

    @Column(name = "login")
    private String login;


    @ManyToMany
    @JoinTable(name = "table_user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id"))
    private Set<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    // истёк ли срокдействия учётной записи
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    // заблакирован ли аккаунт
    public boolean isAccountNonLocked() {
        return true;
    }

    //    истек ли срок действия учетных данных пользователя (пароль)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //доступен ли веб-элемент для взаимодействия (например, нажатия или ввода текста).
    @Override
    public boolean isEnabled() {
        return true;
    }

    public User(Integer age, String email, String firstName, String lastName, String password, String login) {
        this.age = age;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.login = login;
    }
}

