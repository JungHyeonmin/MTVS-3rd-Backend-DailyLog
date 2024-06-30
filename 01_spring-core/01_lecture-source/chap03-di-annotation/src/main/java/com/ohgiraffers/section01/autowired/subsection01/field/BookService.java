package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// @Service : 서비스 레이어, 비즈니스 로직을 가진 클래스.(사용자의 요청에 맞는 서비스를 제공) ex) Service Class

@Service("bookServiceField") // 서비스 계층, 이름이 충돌나지 않게 이름을 설정
public class BookService {

    // @Autowired : Type 을 통한 DI를 할 때 사용한다. 스프링 컨테이너가 알아서 해당 타입의 Bean 을 찾아서 주입해준다.
    // 필요한 의존 객체의  'Type' 에 해당하는 빈을 찾아서 주입한다. (BookDAO 타입에 Bean 이 존재해야 넣어준다.)
    @Autowired
    private BookDAO bookDAO;
    // -> 필드 주입
    // private BookDAO bookDAO = new BookDAOImpl();
    // 와 같이 필드를 선언한다면 BookService 클래스는 BookDAOImpl 클래스의 변경에 직접적으로 영향을 받는 강한 결합을 가지게 된다.
    // 객체간의 결합을 느슨하게 하기 위해 new BookDAOImpl() 와 같은 직접적으로 객체를 생성하는 생성자 구문을 제거하고 필드에 @Autowired 어노테이션을 작성할 수 있다.
    // 그러면 스프링 컨테이너는 BookService 빈 객체 생성 시 BookDAO 타입의 빈 객체를 찾아 의존성을 주입해준다.

    // 모든 책 조회
    public List<BookDTO> findAllBooks() {

        return bookDAO.findAllBooks();
    }

    // 리스트에 저장한 책들 중 원하는 index 값으로 책을 조회한다.
    public BookDTO findBookBySeq(int seq) {

        return bookDAO.findBookBySeq(seq);
    }
}
