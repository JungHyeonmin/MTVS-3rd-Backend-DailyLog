package com.ohgiraffers.section01.autowired.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

// 컴포넌트로 Bean 설정할 수 있다. 하지만 계층에 따라서 알맞은 어노테이션을 사용해야 한다.
// 이 클래스를 빈으로 설정해서 @Autowired 를 통해 자유롭게 사용할 것이다.

// DAO는 Repository계층이라서 @Repository를 사용해야 한다.
@Repository("bookDAO") // BookDAO라는 이름으로 빈이 생성된다.
@Component // 컴포넌트사용 -> @Configuration 왜 사용하지 않는거지?
public class BookDAOImpl implements BookDAO {

    private final Map<Integer, BookDTO> bookList;

    public BookDAOImpl() {
        bookList = new HashMap<Integer, BookDTO>();

        bookList.put(1, new BookDTO(1, 123456, "자바의 정석", "남궁성", "도우출판", new Date()));
        bookList.put(2, new BookDTO(2, 654321, "칭찬은 고래도 춤추게 한다.", "고래", "고래출판", new Date()));
    }

    @Override
    public List<BookDTO> findAllBooks() {
        return new ArrayList<>(bookList.values());
    }

    @Override
    public BookDTO findBookBySeq(int seq) {
        return bookList.get(seq);
    }
}