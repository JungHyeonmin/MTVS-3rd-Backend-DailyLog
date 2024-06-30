package com.ohgiraffers.section01.autowired.common;

import java.util.List;

// DTO : 계층 간 데이터 교환을 위한 객체
// DAO : 실제로 DB의 데이터에 접근하는 객체

public interface BookDAO {

    /* 도서 목록 전체 조회 */
    List<BookDTO> findAllBooks();

    /* 도서 번호로 도서 조회 */
    BookDTO findBookBySeq(int seq);

}
