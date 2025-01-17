package com.utkarsh.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;
    private String mobile;
    private String role;
    private boolean confirmed;

    private String emailValidationToken;

    public User(String username, String password, String email, String mobile, String role, boolean confirmed) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.role = role;
        this.confirmed = confirmed;
    }
}
