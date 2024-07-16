package com.ohgiraffers.section03.remix;

import java.util.List;

// 인터페이스와 xml 을 자동으로 연결해서 사용할 수 있다!!!!
// 쿼리는 xml, 호출은 Mapper 에 작성한다.
// xml과 interface 의 이름이 같아야한다.
// resources 와 main 패키지가 같아야한다.
// namespace 을 풀네임을 작성해야한다.

public interface MenuMapper {

    List<MenuDTO> findAllMenus();
}