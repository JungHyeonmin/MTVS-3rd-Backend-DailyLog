package com.ohgiraffers.section01.autowired.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

// 컴포넌트로 Bean 설정할 수 있다. 하지만 계층에 따라서 알맞은 어노테이션을 사용해야 한다.
// 이 클래스를 빈으로 설정해서 @Autowired 를 통해 자유롭게 사용할 것이다.

// BookDAO 는 Repository 계층이라서 @Repository 를 사용해야 한다. // Repository 계층 : db와 연결해주는 계층

//@Repository : 퍼시스턴스(persistence)레이어, 영속성을 가지는 속성(파일, 데이터베이스)을 가진 클래스.
// (서비스의 데이터를 받는 부분) ex) Data Access Object Class
//  -> persistence layer : DB와 연결된 계층 | 영속성 : 데이터를 생성한 프로그램이 종료되어도 사라지지 않는 데이터의 특성


// 인터페이스와 구현체를 나누는 이유
// 인터페이스를 통해 클라이언트 코드와 실제 구현을 분리할 수 있습니다.
// 클라이언트 코드는 인터페이스에 의존하며, 실제 구현 클래스가 변경되더라도 클라이언트 코드를 수정할 필요가 없습니다.

// 인터페이스가 아닌 구현체를 이용해서 주입을 해야한다.

@Repository("bookDAO") // BookDAO 라는 이름으로 빈이 생성된다.
public class BookDAOImpl implements BookDAO {

    private final Map<Integer, BookDTO> bookList;

    public BookDAOImpl() {
        bookList = new HashMap<Integer, BookDTO>();

        bookList.put(1, new BookDTO(1, 123456, "자바의 정석", "남궁성", "도우출판", new Date()));
        bookList.put(2, new BookDTO(2, 654321, "칭찬은 고래도 춤추게 한다.", "고래", "고래출판", new Date()));
    }

    /* 도서 목록 전체 조회 */
    @Override
    public List<BookDTO> findAllBooks() {
        return new ArrayList<>(bookList.values());
    }

    /* 도서 번호로 도서 조회 */
    @Override
    public BookDTO findBookBySeq(int seq) {
        return bookList.get(seq);
    }
}