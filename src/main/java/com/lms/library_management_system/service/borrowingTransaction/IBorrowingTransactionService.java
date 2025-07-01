package com.lms.library_management_system.service.borrowingTransaction;

import com.lms.library_management_system.model.BorrowingTransaction;

import java.util.List;

public interface IBorrowingTransactionService {
    List<BorrowingTransaction> getAll();
    BorrowingTransaction getById(Long id);
    BorrowingTransaction borrowBook(Long memberId, Long bookId);
    BorrowingTransaction returnBook(Long transactionId);
    void delete(Long id);
}
