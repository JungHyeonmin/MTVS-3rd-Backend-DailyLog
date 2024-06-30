package com.ohgiraffers.section01.autowired.subsection02.constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        /* AnnotationConfigApplicationContext 생성자에 basePackages 문자열을 전달하며 ApplicationContext 생성한다. */
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01");

        BookService bookService = (BookService) context.getBean("bookServiceConstructor");

        bookService.findAllBooks().forEach(System.out::println);

        System.out.println(bookService.searchBookBySequence(1));
        System.out.println(bookService.searchBookBySequence(2));
    }
}
