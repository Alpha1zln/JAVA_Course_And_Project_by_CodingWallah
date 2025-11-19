package com.alpha1zln.simpleBookMgmt.service;

import com.alpha1zln.simpleBookMgmt.model.Book;
import com.alpha1zln.simpleBookMgmt.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    public Book addBook(Book book) {
        return repo.save(book);
    }

    public Collection<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book getBook(int id) {
        // if (!repo.existsById(id)) {
        //     return "Book not found";
        // }
        return repo.findById(id);
    }

    public String updateBook(int id, Book book) {
        if (!repo.existsById(id)) {
            return "Book not found";
        }
        repo.save(book);
        return "Book updated";
    }

    public String deleteBook(int id) {
        if (!repo.existsById(id)) {
            return "Book not found";
        }
        repo.deleteById(id);
        return "Book deleted";
    }
}
