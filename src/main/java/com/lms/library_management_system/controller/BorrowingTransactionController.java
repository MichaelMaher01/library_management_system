package com.lms.library_management_system.controller;

import com.lms.library_management_system.model.BorrowingTransaction;
import com.lms.library_management_system.service.borrowingTransaction.IBorrowingTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class BorrowingTransactionController {
    private final IBorrowingTransactionService service;



    @GetMapping("/all")
    @PreAuthorize("hasRole('LIBRARIAN')")
    public List<BorrowingTransaction> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('LIBRARIAN')")
    public ResponseEntity<BorrowingTransaction> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/borrow")
    @PreAuthorize("hasAnyRole('LIBRARIAN', 'STAFF')")
    public ResponseEntity<BorrowingTransaction> borrowBook(
            @RequestParam Long memberId,
            @RequestParam Long bookId) {
        return ResponseEntity.ok(service.borrowBook(memberId, bookId));
    }

    @PostMapping("/return/{id}")
    @PreAuthorize("hasAnyRole('LIBRARIAN', 'STAFF')")
    public ResponseEntity<BorrowingTransaction> returnBook(@PathVariable Long id) {
        return ResponseEntity.ok(service.returnBook(id));
    }

    @DeleteMapping("/{id}/delete")
    @PreAuthorize("hasAnyRole('ADMIN', 'LIBRARIAN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
