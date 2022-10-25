package com.mostafa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.entity.Book.java: SpringBootJUnitMockito-TDD
 * @CreationDate 10/2/2022 12:27 PM
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Size(min = 1, max = 50)
    private String name;

    @NotEmpty
    @Size(min = 1, max = 30)
    private String author;

    @NotNull
    private String publisher;
}
