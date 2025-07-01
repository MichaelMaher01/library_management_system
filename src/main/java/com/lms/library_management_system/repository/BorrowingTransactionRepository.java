package com.lms.library_management_system.repository;

import com.lms.library_management_system.model.BorrowingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingTransactionRepository extends JpaRepository<BorrowingTransaction ,Long> {
}
