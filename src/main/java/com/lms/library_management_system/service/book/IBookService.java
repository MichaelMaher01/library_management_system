package com.lms.library_management_system.service.book;

import com.lms.library_management_system.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book getById(Long id);
    Book create(Book book);
    Book update(Long id, Book updatedBook);
    void delete(Long id);
}
