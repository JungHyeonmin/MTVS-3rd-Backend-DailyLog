package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        // ApplicationContext : 스프링 어플리케이션 전반에 걸쳐 모든 구성요소의 제어 작업을 담당하는 IOC 엔진
        // AnnotationConfigApplicationContext() : 자바 스프링 컨테이너 중 하나이다. Java Configuration 형태의 Configuration Metadata 를 사용하여 Bean 을 생성한다.

        // 생성자에 @Configuration 어노테이션이 달린 설정 클래스의 메타 정보를 전달한다.
        // @Configuration 설정 파일의 위치를 지정한다.
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // @Configuration 설정 파일에서 "member"라는 이름을 가진 빈을 MemberDTO 클래스로 캐스팅하여 전달한다.
        MemberDTO member = context.getBean("member", MemberDTO.class); // 빈의 id 를 작성해야 한다.

        // bean 객체를 출력한다.
        System.out.println("member = " + member);
    }
}
