package com.ohgiraffers.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// @Bean : 메서드 레벨에서 선언하며, 반환하는 객체(인스턴스)를 개발자가 수동으로 bean 으로 등록시키는 어노테이션
// @Component : 클래스 레벨에서 선언함으로써 스프링이 런타임시에 컴포넌트스캔을 하여 자동으로 bean 을 찾고 등록하는 어노테이션
// 개발자가 컨트롤 불가능한 외부 라이브러리의 경우 -> @Beam
// 개발자가 직접 컨트롤이 가능한 내부 클래스의 경우 -> @Component
@Component("memberDAO")
public class MemberDAO {

    private final Map<Integer, MemberDTO> memberMap; // 소문자인 이유 : 수정 방지의 의미, field에 final을 붙인 이유 : 필드를 final로 작성하는 것이 안정적이다.

    public MemberDAO() {
        memberMap = new HashMap<Integer, MemberDTO>(); // Map은 참조 자료형이라서 선언하지 않으면 null값이 들어간다. + 이런 방법이 자주 사용되고 권장하는 방법이다.

        memberMap.put(1, new MemberDTO(1, "user01", "pass01", "홍길동")); // MemberDTO에 member객체 저장 후 memberMap에 추가
        memberMap.put(2, new MemberDTO(2, "user02", "pass02", "유관순"));
    }

    // memberMap 에서 원하는 인덱스의 값을 가져온다.
    public MemberDTO findMemberBySeq(int seq) {
        return memberMap.get(seq);
    }

    // memberMap 에 원하는 키에 값을 저장한다.
    public boolean save(MemberDTO member) {
        int before = memberMap.size(); // before : memberMap 에 총 몇개의 값이 들어가 있는지 확인
        memberMap.put(member.getSequence(), member); // memberMap 에 키와 값을 넣는다.// sequence : 고유한 숫자나 식별자

        int after = memberMap.size(); // after : memberMap 에 총 몇개의 값이 들어가 있는지 확인

        return after > before; // 제대로 값이 들어가서 memberMap 의 총량이 늘었다면 true 를 반환
    }
}
