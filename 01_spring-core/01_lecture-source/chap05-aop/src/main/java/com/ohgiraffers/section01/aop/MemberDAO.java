package com.ohgiraffers.section01.aop;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

// 데이터베이스에 엑세스 하는 용도
@Repository
public class MemberDAO {
    private final Map<Long, MemberDTO> memberMap;

    public MemberDAO() {
        memberMap = new HashMap<>();
        memberMap.put(1L, new MemberDTO(1L, "유관순"));
        memberMap.put(2L, new MemberDTO(2L, "홍길동"));
    }

    public Map<Long,MemberDTO> findAllMembers() {
        return memberMap;
    }

    public MemberDTO findMemberById(Long id) {
        MemberDTO returnMember = memberMap.get(id);

        if (returnMember == null) {
            throw new RuntimeException("해당하는 id의 회원이 없습니다.");
        }
        return returnMember;
    }


}
