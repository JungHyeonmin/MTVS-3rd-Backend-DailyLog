package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.autowired.common.BookDAO;
import com.ohgiraffers.section01.autowired.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookServiceConstructor") // 같은 @Service Bean이지만 이름은 다르다.ㄴ
public class BookService {

    private final BookDAO bookDAO;

    //스프링 버전 4부터는 생성자에 @AutoWired를 생략해도 된다. 하지만 생성자 2개 이상부터는 생략불가하다.
    // @Autowired // 생성자에 @Autowired
    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> findAllBooks() {

        return bookDAO.findAllBooks();
    }

    public BookDTO findBookBySeq(int seq) {

        return bookDAO.findBookBySeq(seq);

    }
}
