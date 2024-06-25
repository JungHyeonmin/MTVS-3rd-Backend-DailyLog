package com.ohgiraffers.section01.autowired.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository("bookDAO")
public class BookDAOImpl implements BookDAO {

    private final Map<Integer, BookDTO> bookList;

    public BookDAOImpl() {
        bookList = new HashMap<Integer, BookDTO>();
        bookList.put(1, new BookDTO(1, 123456, "자바의정석", "남궁성", "도우출판", new Date()));
        bookList.put(2, new BookDTO(2, 654321, "칭찬은 고래도 춤추게 한다", "고래", "고래출판", new Date()));
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
