package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// java 설정

// @Configuration : 해당 클래스가 Java 기반 Configuration Metadata 로 빈을 생성하는 클래스임을 표기한다.
@Configuration
public class ContextConfiguration {

    // @Bean : 해당 메서드의 반환값을 스프링 컨테이너에 빈으로 등록한다는 어노테이션

    // 생성하는 bean 의 이름을 "member"로 표기한다. - bean 의 이름을 별도로 지정하지 않으면 메서드 이름을 bean 의 id 로 인식한다.
    @Bean() // 빈의 이름을 설정
    public MemberDTO getMember() {

        System.out.println("getMember 호출함...");

        // MemberDTO 의 객체를 빈으로 생성
        return new MemberDTO(1, "ueser01", "pass01", "홍길동");
    }
}
