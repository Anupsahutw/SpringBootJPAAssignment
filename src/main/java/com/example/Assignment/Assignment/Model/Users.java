package com.example.Assignment.Assignment.Model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
@Data
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull(message = "UserName cannot be null")
    @NotEmpty(message = "Please provide user name")
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Please provide password")
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull(message = "name cannot be null")
    @NotEmpty(message = "Please provide name")
    @Column(name = "name", nullable = false)
    private String name;

    public Users(String username,String password,String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public Users() {

    }
}
