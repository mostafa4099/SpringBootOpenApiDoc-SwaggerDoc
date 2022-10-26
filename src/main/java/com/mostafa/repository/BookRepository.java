package com.mostafa.repository;

import com.mostafa.entity.Book;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.repository.BookRepository.java: SpringBootJUnitMockito-TDD
 * @CreationDate 10/2/2022 12:35 PM
 */
@Tag(name = "Repository APIs", description= "All APIs from Repository")
public interface BookRepository extends JpaRepository<Book, Long> {
}
