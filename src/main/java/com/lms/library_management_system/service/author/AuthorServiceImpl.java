package com.lms.library_management_system.service.author;

import com.lms.library_management_system.model.Author;
import com.lms.library_management_system.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AuthorServiceImpl implements IAuthorService{
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author getById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }

    @Override
    public Author create(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author update(Long id, Author updatedAuthor) {
        Author author = getById(id);
        author.setName(updatedAuthor.getName());
        return authorRepository.save(author);
    }

    @Override
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }

}
