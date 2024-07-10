package com.ohgiraffers.requestmapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @Retention(RetentionPolicy.RUNTIME) : 런타임일때 실행
// @SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan(
@SpringBootApplication // 인터페이스(런타임때 실행, 컴포넌트스캔이 활성되어있다.)
public class Chap01RequestMappingApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap01RequestMappingApplication.class, args); // SpringBoot 을 시작시키는 메서드
    }

}
