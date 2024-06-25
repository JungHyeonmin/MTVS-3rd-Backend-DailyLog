package com.ohgiraffers.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// DAO : Database Access Object
@Component
public class MemberDAO {

    private final Map<Integer, MemberDTO> memberMap; // 소뮨자인 이유 : 수정 방지의 의미, field에 final을 붙인 이유 : 필드를 final로 작성하는 것이 안정적이다.

    public MemberDAO() {
        memberMap = new HashMap<Integer, MemberDTO>(); // Map은 참조 자료형이라서 선언하지 않으면 null값이 들어간다. + 이런 방법이 자주 사용되고 권장하는 방법이다.

        memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동")); // MemberDTO에 member객체 저장 후 memberMap에 추가
        memberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
    }

    public MemberDTO findMemberBySeq(int seq) {
        return memberMap.get(seq);
    }

    public boolean save(MemberDTO member) {
        int before = memberMap.size();
        memberMap.put(member.getSequence(), member);

        int after = memberMap.size();

        return after > before;
    }
}
