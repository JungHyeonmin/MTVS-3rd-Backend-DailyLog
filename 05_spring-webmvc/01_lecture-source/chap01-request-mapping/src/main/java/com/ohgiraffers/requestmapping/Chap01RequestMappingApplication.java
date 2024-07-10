package com.ohgiraffers.requestmapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 스프링 부트 애플리케이션 클래스는 @SpringBootApplication 어노테이션을 포함한다.
 * 이 어노테이션은 @Configuration, @EnableAutoConfiguration, @ComponentScan 세 가지 어노테이션을 하나로 묶은 것이다.
 * // @EnableAutoConfiguration 어노테이션은 Spring Boot 의 자동 설정을 활성화하고,
 * // @ComponentScan 어노테이션은 스프링이 컴포넌트를 찾아서 빈으로 등록할 수 있도록 설정한다.
 * // @Configuration 어노테이션을 사용하면, 하나 이상의 @Bean 이 붙은 메서드가 포함된 빈 설정용 클래스를 만들 수 있다.
 */
@SpringBootApplication // 인터페이스(런타임때 실행, 컴포넌트스캔이 활성되어있다.)
public class Chap01RequestMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap01RequestMappingApplication.class, args); // SpringBoot 을 시작시키는 메서드
    }

}
