package com.ohgiraffers.mapping.section01.entity;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberRegistService {

    // 단일 책임의 원칙 : 클라이언트 1개당 책임(Service) 1개

    private MemberRepository memberRepository;

    @Autowired
    public MemberRegistService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    // DTO 와 Entity 의 변환도 Service 의 역할이다.
    @Transactional
    public void registMember(MemberRegistRequestDTO memberInfo) {
        // Member 생성자를 이용해서 엔티티 생성 후 바로 테이블에 값 대입
        Member member = new Member(
                memberInfo.getMemberId(),
                memberInfo.getMemberPwd(),
                memberInfo.getMemberName(),
                memberInfo.getPhone(),
                memberInfo.getAddress(),
                memberInfo.getEnrollDate(),
                memberInfo.getMemberRole(),
                memberInfo.getStatus()
        );

        memberRepository.save(member);
    }
}
