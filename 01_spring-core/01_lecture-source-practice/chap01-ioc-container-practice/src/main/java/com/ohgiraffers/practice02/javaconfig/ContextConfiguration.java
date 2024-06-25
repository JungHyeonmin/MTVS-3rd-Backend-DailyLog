package com.ohgiraffers.practice02.javaconfig;

import com.ohgiraffers.common.BoardDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Spring 에서 bean 을 수동으로 등록하기 위해서는, 설정 class 위에 @Configuration 을 추가하고, @Bean 을 사용해서 빈을 등록할 수 있다.
// @Configuration : 스프링 컨테이너는 @Configuration 이 붙어있는 클래스를 자동으로 빈으로 등록해준다.
@Configuration
public class ContextConfiguration {

    @Bean("board") // 스프링 컨테이너가 관리하는 자바 객체를 의미한다.()안에 빈의 이름을 넣을 수 있다.
    public BoardDTO getBoard(){ // BoardDTO 객체를 생성하고 반환
        System.out.println("getBoard 호출함...");

        // BoardDTO 객체를 하나 생성
        return new BoardDTO(1L, "스프링 수업이 앞으로 많이 어려워질까요?", "그래도 포기하지 않고 열심히 해볼거예요!", "미래의 멋진 개발자");
    }
}
