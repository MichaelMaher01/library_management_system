package com.lms.library_management_system.service.member;

import com.lms.library_management_system.model.Member;

import java.util.List;

public interface IMemberService {
    List<Member> getAll();
    Member getById(Long id);
    Member create(Member member);
    Member update(Long id, Member member);
    void delete(Long id);
}
