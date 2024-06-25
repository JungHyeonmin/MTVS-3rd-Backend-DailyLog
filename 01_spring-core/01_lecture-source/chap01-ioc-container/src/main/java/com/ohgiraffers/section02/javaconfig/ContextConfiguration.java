package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// java 설정

@Configuration // class 자체가 하나의 빈이 된다.
public class ContextConfiguration {

    // spring-context.xml과 같은 설정이다.
    @Bean("member") // 빈의 이름을 설정
    public MemberDTO getMember() {

        System.out.println("getMember 호출함...");

        return new MemberDTO(1, "ueser01", "pass01", "홍길동");
    }

}
