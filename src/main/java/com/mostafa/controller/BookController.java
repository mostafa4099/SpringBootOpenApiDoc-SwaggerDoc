package com.mostafa.controller;

import com.mostafa.entity.Book;
import com.mostafa.excption.NotFoundException;
import com.mostafa.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Md. Golam Mostafa | mostafa.sna@gmail.com
 * @File com.mostafa.controller.BookController.java: SpringBootJUnitMockito-TDD
 * @CreationDate 10/2/2022 12:49 PM
 */
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Operation(summary = "Get Book List", description = "Get all saved books",
            tags = {"GET", "BookList"}, operationId = "getAll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "404", description = "No book found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)))})
    @GetMapping
    public List<Book> getAllBookList() throws NotFoundException {
        return bookService.findAllBooks();
    }

    @Operation(summary = "Get Book", description = "Get the saved book by id",
            tags = {"GET", "Book"}, operationId = "getOne")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found Book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid Id",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "404", description = "No book found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)))})
    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") long id) throws NotFoundException {
        return bookService.findBookById(id);
    }

    @Operation(summary = "Save Book", description = "Save provided new book",
            tags = {"POST", "Book"}, operationId = "save")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Saved Book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid Data",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)))})
    @PostMapping
    public Book saveBook(@Valid @RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @Operation(summary = "Modify Book", description = "Modify existing book info",
            tags = {"PUT", "Book"}, operationId = "modify")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modified Book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid Data",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "404", description = "Provided BooK Not Found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)))})
    @PutMapping
    public Book updateBook(@Valid @RequestBody Book book) throws NotFoundException {
        return bookService.updateBook(book);
    }

    @Operation(summary = "Delete Book", description = "Delete provided book",
            tags = {"DELETE"}, operationId = "delete")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted Book",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid Data",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "404", description = "Provided BooK Not Found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)))})
    @DeleteMapping
    public String deleteBook(@RequestBody Book book) throws NotFoundException {
        return bookService.deleteBook(book);
    }
}
