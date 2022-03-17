package com.example.mysqldemo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "book")
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    private Long isbn;
    private Integer totalPages;
    private Double rating;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id")
    @JsonIgnoreProperties(value = "book")
    private Photo photo;
}