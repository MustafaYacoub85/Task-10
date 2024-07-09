package ru.itmentor.spring.boot_security.demo.controller.payload;

public record UpdateUserPayload(String firstName, String lastName,String email, int age) {
}