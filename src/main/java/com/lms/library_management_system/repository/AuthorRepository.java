package com.lms.library_management_system.repository;

import com.lms.library_management_system.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author ,Long> {
}
