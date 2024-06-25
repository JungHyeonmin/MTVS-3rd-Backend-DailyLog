package com.ohgiraffers.practice03.annotationconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @Configuration : 빈 설정 파일임을 알려준다.
// @ComponentScan : 빈으로 등록되기 위해 어노테이션이 부여된 클래스들을 자동으로 IoC 컨테이너에 등록해준다.
@Configuration
@ComponentScan(basePackages = "com.ohgiraffers")
public class ContextConfiguration {

}
