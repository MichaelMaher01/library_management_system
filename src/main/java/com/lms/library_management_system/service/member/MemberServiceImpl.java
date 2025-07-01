package com.lms.library_management_system.service.member;

import com.lms.library_management_system.model.Member;
import com.lms.library_management_system.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements IMemberService {

    private final MemberRepository memberRepository;
    @Override
    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    @Override
    public Member getById(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    @Override
    public Member create(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member update(Long id, Member updatedMember) {
        Member existing = getById(id);
        existing.setName(updatedMember.getName());
        existing.setEmail(updatedMember.getEmail());
        existing.setPhone(updatedMember.getPhone());
        existing.setAddress(updatedMember.getAddress());
        return memberRepository.save(existing);

    }

    @Override
    public void delete(Long id) {
        memberRepository.deleteById(id);

    }
}
