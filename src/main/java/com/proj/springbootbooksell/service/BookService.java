package com.proj.springbootbooksell.service;

import com.proj.springbootbooksell.model.Book;
import com.proj.springbootbooksell.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookService implements IBookService{

     @Autowired
     private IBookRepository bookRepository;


     @Override
     public Book saveBook(Book book){

            book.setCreateTime(LocalDateTime.now());
            return bookRepository.save(book);
     }


     @Override
     public void deleteBook(Long id){

            bookRepository.deleteById(id);
     }

     @Override
     public List<Book> findAllBooks(){

            return bookRepository.findAll();
     }
}
