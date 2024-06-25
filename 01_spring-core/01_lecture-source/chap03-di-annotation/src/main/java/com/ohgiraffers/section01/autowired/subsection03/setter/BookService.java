package com.ohgiraffers.section01.autowired.subsection03.setter;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceSetter")
public class BookService {
    private BookDAO bookDAO;

    // Setter 주입 - 필드와 생성자 주입에 비해서 잘 사용하지 않는다.
    // final 사용 불가 == 필드 주입
    // 생성자 주입에 비해서 테스트 코드를 작성하기 힘들다.
    // 순환참조 구조에서 생성자 주입처럼 실행과정에서 에러가 발생한다.

    @Autowired // 타입이 일치하는 Bean을 찾아서 주입하는 방식
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> findAllBooks() {

        return bookDAO.findAllBooks();

    }

    public BookDTO findBookBySeq(int seq) {

        return bookDAO.findBookBySeq(seq);
    }
}