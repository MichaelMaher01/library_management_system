package com.lms.library_management_system.service.book;

import com.lms.library_management_system.model.Author;
import com.lms.library_management_system.model.Book;
import com.lms.library_management_system.repository.AuthorRepository;
import com.lms.library_management_system.repository.BookRepository;
import com.lms.library_management_system.repository.CategoryRepository;
import com.lms.library_management_system.repository.PublisherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BookServiceImpl implements IBookService{

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorRepository authorRepository;
    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book getById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @Override
    public Book create(Book book) {
        validateRelations(book);
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, Book updatedBook) {
        Book existing = getById(id);
        existing.setTitle(updatedBook.getTitle());
        existing.setIsbn(updatedBook.getIsbn());
        existing.setPublicationYear(updatedBook.getPublicationYear());
        existing.setEdition(updatedBook.getEdition());
        existing.setSummary(updatedBook.getSummary());
        existing.setCoverImageUrl(updatedBook.getCoverImageUrl());
        existing.setLanguage(updatedBook.getLanguage());

        existing.setPublisher(updatedBook.getPublisher());
        existing.setCategory(updatedBook.getCategory());
        existing.setAuthors(updatedBook.getAuthors());

        validateRelations(existing);

        return bookRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);

    }

    private void validateRelations(Book book) {
        if (book.getPublisher() != null)
            publisherRepository.findById(book.getPublisher().getId())
                    .orElseThrow(() -> new RuntimeException("Invalid publisher"));

        if (book.getCategory() != null)
            categoryRepository.findById(book.getCategory().getId())
                    .orElseThrow(() -> new RuntimeException("Invalid category"));

        if (book.getAuthors() != null && !book.getAuthors().isEmpty()) {
            for (Author author : book.getAuthors()) {
                authorRepository.findById(author.getId())
                        .orElseThrow(() -> new RuntimeException("Invalid author id: " + author.getId()));
            }
        }
    }
}
