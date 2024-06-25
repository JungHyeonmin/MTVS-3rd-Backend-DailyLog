package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        // ApplicationContext : 스프링 어플리케이션 전반에 걸쳐 모든 구성요소의 제어 작업을 담당하는 IOC 엔진 
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class); // 설정파일의 클래스 메타정보를 입력해야 한다.

        MemberDTO member = context.getBean("member", MemberDTO.class); // 빈의 이름을 작성해야 한다.
        System.out.println("member = " + member);
    }
}
