package ru.kustikov.cakes.users;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {
    private Long userId;

    private String email;

    private String phone;

    private String username;

    private String description;

    private String password;

    private String role;

    private String image;

    private Timestamp lastActivity;
}
