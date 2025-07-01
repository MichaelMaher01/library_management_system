package com.lms.library_management_system.service.author;

import com.lms.library_management_system.model.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> getAll();
    Author getById(Long id);

    Author create(Author author);
    Author update(Long id, Author author);
    void delete(Long id);
}
