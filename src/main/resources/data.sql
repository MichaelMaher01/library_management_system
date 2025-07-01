-- Publishers
INSERT INTO publishers (name) VALUES ('O''Reilly Media');
INSERT INTO publishers (name) VALUES ('Springer');

-- Categories
INSERT INTO categories (name, parent_id) VALUES ('Science', NULL);
INSERT INTO categories (name, parent_id) VALUES ('Programming', 1);
INSERT INTO categories (name, parent_id) VALUES ('Mathematics', 1);

-- Authors
INSERT INTO authors (name) VALUES ('Martin Fowler');
INSERT INTO authors (name) VALUES ('Robert C. Martin');
INSERT INTO authors (name) VALUES ('Donald Knuth');

-- Books
INSERT INTO books (title, isbn, publication_year, edition, summary, cover_image_url, language, publisher_id, category_id)
VALUES ('Refactoring', '978-0201485677', 2018, '2nd', 'Refactoring is about improving the design of existing code.', NULL, 'English', 1, 2);
INSERT INTO books (title, isbn, publication_year, edition, summary, cover_image_url, language, publisher_id, category_id)
VALUES ('Clean Code', '978-0132350884', 2008, '1st', 'A Handbook of Agile Software Craftsmanship.', NULL, 'English', 1, 2);
INSERT INTO books (title, isbn, publication_year, edition, summary, cover_image_url, language, publisher_id, category_id)
VALUES ('The Art of Computer Programming', '978-0201896831', 1997, '3rd', 'Comprehensive monograph written by Donald Knuth.', NULL, 'English', 2, 3);

-- Book & Author (ManyToMany)
INSERT INTO book_author (book_id, author_id) VALUES (1, 1);
INSERT INTO book_author (book_id, author_id) VALUES (2, 2);
INSERT INTO book_author (book_id, author_id) VALUES (3, 3);

-- Members
INSERT INTO members (name, email, phone, address) VALUES ('Ahmed Mohamed', 'ahmed@example.com', '0123456789', 'Cairo, Egypt');
INSERT INTO members (name, email, phone, address) VALUES ('Sara Ali', 'sara@example.com', '0111122233', 'Giza, Egypt');

-- Borrowing Transactions
INSERT INTO borrowing_transactions
(member_id, book_id, borrow_date, due_date, return_date, status)
VALUES
    (1, 1, '2024-05-01', '2024-05-10', NULL, 'BORROWED'),
    (2, 2, '2024-04-01', '2024-04-10', '2024-04-09', 'RETURNED');

