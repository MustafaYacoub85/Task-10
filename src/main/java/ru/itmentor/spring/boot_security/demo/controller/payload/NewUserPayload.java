package ru.itmentor.spring.boot_security.demo.controller.payload;

public record NewUserPayload(String firstName, String lastName,String email, int age,String login,String password) {
}
