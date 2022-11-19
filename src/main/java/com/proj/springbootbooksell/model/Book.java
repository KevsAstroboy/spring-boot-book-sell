package com.proj.springbootbooksell.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "book")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="title",nullable = false,length = 100)
    private String title;

    @Column(name = "description",nullable = false,length = 100)
    private String description;

    @Column(name ="author",nullable = false,length = 100)
    private String author;

    @Column(name = "price",nullable = false,length = 100)
    private Double price;

    @Column(name = "create_time")
    private LocalDateTime createTime;
}
