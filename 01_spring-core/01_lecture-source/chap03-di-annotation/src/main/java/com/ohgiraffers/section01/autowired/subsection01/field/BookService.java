package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceField") // 서비스 계층, 이름이 충돌나지 않게 이름을 설정
public class BookService {

    @Autowired // 컨테이너가 Bean으로 가지고 있는 것들 중에서 이름이 맞는 것을 찾아서 넣어준다. (BookDAO 타입에 Bean이 존재해야 넣어준다.)
    private BookDAO bookDAO;


    public List<BookDTO> findAllBooks() {

        return bookDAO.findAllBooks();
    }

    public BookDTO findBookBySeq(int seq) {

        return bookDAO.findBookBySeq(seq);
    }
}
