package org.example.ex1.service;


import org.example.ex1.dto.BookCreateDTO;
import org.example.ex1.entity.Book;
import org.example.ex1.repositoty.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {



    @Autowired

    private BookRepository bookRepository;

    public List<Book> getBookAll(){

        return bookRepository.findAll();

    }
    public Book createBook(BookCreateDTO bookCreateDTO){
        Book newBook =  Book.builder()
                .name(bookCreateDTO.getName())
                .author(bookCreateDTO.getAuthor())
                .category(bookCreateDTO.getCategory())
                .price(bookCreateDTO.getPrice())
                .build();

        return bookRepository.save(newBook);

    }

    public Book findById(Long id){
        return bookRepository.findById(id).orElse(null);
    }

    public Book updateBook(Long id, BookCreateDTO  bookCreateDTO){
        Book book = findById(id);

        if(book == null){
            throw new IllegalArgumentException("Error");
        }

        book.setName(bookCreateDTO.getName());
        book.setAuthor(bookCreateDTO.getAuthor());
        book.setCategory(bookCreateDTO.getCategory());
        book.setPrice(bookCreateDTO.getPrice());

        return bookRepository.save(book);
    }


    public void deleteBool(Long id){
        Book book = findById(id);

        if(book == null){
            throw new IllegalArgumentException("Error");
        }

        bookRepository.delete(book);

    }




}
