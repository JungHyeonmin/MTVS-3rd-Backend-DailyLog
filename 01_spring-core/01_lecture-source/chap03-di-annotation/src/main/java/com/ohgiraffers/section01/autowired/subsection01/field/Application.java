package com.ohgiraffers.section01.autowired.subsection01.field;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        // @Autowired 를 이용한 의존성 주입


        /* AnnotationConfigApplicationContext 생성자에 basePackages 문자열을 전달하며 ApplicationContext 생성한다. */
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01"); // 자바 설정파일이 없는 상태 -> 문자열로 배이스 파일을 설정한다

        // id 가 bookServiceField 인 bean 을 찾아서 반환하고 BookService 로 캐스팅한다.
        BookService bookService = (BookService) context.getBean("bookServiceField");

        //

        // forEach : 하나하나 반복해서 동작해준다.
        // System.out의 println을 반복한다. -> 모든 객체를 하나씩 반복한다.
        bookService.findAllBooks().forEach(System.out::println);
    }
}
