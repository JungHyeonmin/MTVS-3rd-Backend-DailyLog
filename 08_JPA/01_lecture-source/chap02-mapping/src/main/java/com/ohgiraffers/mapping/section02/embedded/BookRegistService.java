package com.ohgiraffers.mapping.section02.embedded;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookRegistService {

    private BookRepository bookRepository;

    @Autowired
    public BookRegistService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void registBook(BookRegistRequestDTO bookInfo) {

        Book book = new Book(
                bookInfo.getBookTitle(),
                bookInfo.getAuthor(),
                bookInfo.getPublisher(),
                bookInfo.getPublishedDate(),
                new Price(
                        bookInfo.getRegularPrice(),
                        bookInfo.getDiscountRate()
                )
        );
        bookRepository.save(book);
    }
}
