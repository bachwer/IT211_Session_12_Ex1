package org.example.ex1.controller;


import jakarta.validation.Valid;
import org.example.ex1.dto.BookCreateDTO;
import org.example.ex1.entity.Book;
import org.example.ex1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class bookController {

    @Autowired
    private BookService bookService;


    @GetMapping
    public List<Book> getBookAll(){
        return bookService.getBookAll();
    }



    @GetMapping("/{id}")
    public Book getBookById(@Valid @PathVariable Long id){

        return bookService.findById(id);
    }


    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody BookCreateDTO bookCreateDTO){

        Book book = bookService.createBook(bookCreateDTO);
        return ResponseEntity.ok(book);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@Valid @PathVariable Long id, @RequestBody BookCreateDTO bookCreateDTO){

        Book book = bookService.updateBook(id, bookCreateDTO);

        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id){
        bookService.deleteBool(id);

        return ResponseEntity.noContent().build();
    }

}
