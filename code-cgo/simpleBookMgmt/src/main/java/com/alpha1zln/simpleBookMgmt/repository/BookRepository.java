package com.alpha1zln.simpleBookMgmt.repository;


import com.alpha1zln.simpleBookMgmt.model.Book;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class BookRepository {

    private Map<Integer, Book> store = new HashMap<>();

    public Book save(Book book) {
        store.put(book.getId(), book);
        return book;
    }

    public Collection<Book> findAll() {
        return store.values();
    }

    public Book findById(int id) {
        return store.get(id);
    }

    public void deleteById(int id) {
        store.remove(id);
    }

    public boolean existsById(int id) {
        return store.containsKey(id);
    }
}
