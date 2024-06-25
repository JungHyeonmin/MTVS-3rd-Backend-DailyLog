package com.ohgiraffers.section01.autowired.subsection03.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        // getBean() : Objedt로 반환하기 때문에 bookService에 값을 주기 위해서 다운캐스팅을 해야한다.
        BookService bookService = (BookService) context.getBean("bookServiceSetter"); // 타입을 잘 몰라서 Object로 반환해서 다운캐스팅

        bookService.findAllBooks().forEach(System.out::println);
    }
}
