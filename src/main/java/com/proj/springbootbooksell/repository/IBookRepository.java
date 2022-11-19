package com.proj.springbootbooksell.repository;

import com.proj.springbootbooksell.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long> {

}
