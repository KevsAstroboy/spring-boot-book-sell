package com.proj.springbootbooksell.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username",length = 100,unique = true,nullable = false)
    private String username;

    @Column(name = "password",nullable = false,length = 100)
    private String password;

    @Column(name = "name",nullable = false,length = 100)
    private String name;

    @Column(name = "create_time",nullable = false)
    private LocalDateTime createTime;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Transient
    private String token;
}
