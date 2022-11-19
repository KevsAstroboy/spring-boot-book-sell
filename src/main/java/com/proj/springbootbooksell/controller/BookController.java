package com.proj.springbootbooksell.controller;

import com.proj.springbootbooksell.model.Book;
import com.proj.springbootbooksell.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/book")
public class BookController {
    @Autowired
    IBookService bookService;

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody Book book ){

           return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @DeleteMapping("{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId){

           bookService.deleteBook(bookId);

           return new ResponseEntity<>(HttpStatus.OK);

    }
    @GetMapping
    public ResponseEntity<?> getAllBooks(){

           return new ResponseEntity<>(bookService.findAllBooks(),HttpStatus.OK);

    }
}
