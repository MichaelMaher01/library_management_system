package com.lms.library_management_system.service.borrowingTransaction;

import com.lms.library_management_system.model.Book;
import com.lms.library_management_system.model.BorrowingTransaction;
import com.lms.library_management_system.model.Member;
import com.lms.library_management_system.repository.BookRepository;
import com.lms.library_management_system.repository.BorrowingTransactionRepository;
import com.lms.library_management_system.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowingTransactionServiceImpl implements IBorrowingTransactionService{
    private final BorrowingTransactionRepository repository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;
    @Override
    public List<BorrowingTransaction> getAll() {
        return repository.findAll();
    }

    @Override
    public BorrowingTransaction getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    @Override
    public BorrowingTransaction borrowBook(Long memberId, Long bookId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        BorrowingTransaction transaction = BorrowingTransaction.builder()
                .member(member)
                .book(book)
                .borrowDate(LocalDate.now())
                .dueDate(LocalDate.now().plusDays(14))
                .status(BorrowingTransaction.BorrowingStatus.BORROWED)
                .build();

        return repository.save(transaction);
    }

    @Override
    public BorrowingTransaction returnBook(Long transactionId) {
        BorrowingTransaction transaction = getById(transactionId);
        transaction.setReturnDate(LocalDate.now());
        transaction.setStatus(BorrowingTransaction.BorrowingStatus.RETURNED);
        return repository.save(transaction);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }
}
