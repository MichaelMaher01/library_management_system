package com.lms.library_management_system.controller;

import com.lms.library_management_system.model.Member;
import com.lms.library_management_system.service.member.IMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberController {
    private final IMemberService memberService;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('LIBRARIAN', 'STAFF')")
    public List<Member> getAll() {
        return memberService.getAll();
    }

    @GetMapping("/member/{id}")
    @PreAuthorize("hasAnyRole('LIBRARIAN', 'STAFF')")
    public ResponseEntity<Member> getById(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getById(id));
    }

    @PostMapping("/create")
    @PreAuthorize("hasAnyRole('LIBRARIAN', 'STAFF')")
    public ResponseEntity<Member> create(@RequestBody Member member) {
        return ResponseEntity.ok(memberService.create(member));
    }

    @PutMapping("/member/{id}/update")
    @PreAuthorize("hasAnyRole('LIBRARIAN', 'STAFF')")
    public ResponseEntity<Member> update(@PathVariable Long id, @RequestBody Member member) {
        return ResponseEntity.ok(memberService.update(id, member));
    }

    @DeleteMapping("/member/{id}/delete")
    @PreAuthorize("hasAnyRole('LIBRARIAN', 'STAFF')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        memberService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
