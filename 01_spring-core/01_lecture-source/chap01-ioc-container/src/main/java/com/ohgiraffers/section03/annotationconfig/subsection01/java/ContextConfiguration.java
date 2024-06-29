package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// @Configuration : 해당 클래스가 Java 기반 Configuration Metadata 로 bean 을 생성하는 클래스임을 표기한다.
// @ComponentScan : base package 로 등록된 경로에 특정 어노테이션(@Component, ...)을 가지고 있는 클래스를 bean 으로 등록하는 기능
// -> @Component 어노테이션이 작성된 클래스를 인식하여 bean 으로 등록한다.
// ->-> 특수 목적에 따라 세부 기능을 제공하는 @Controller, @Service, @Repository, @Configuration 등을 사용한다.

@Configuration
@ComponentScan(basePackages = "com.ohgiraffers")
public class ContextConfiguration {
    // @ComponentScan 으로 "com.ohgiraffers" 패키지부터 하위 모든 패키지들의 bean 을 스캔한다.
}

// @Component : 객체를 나타내는 일반적인 타입으로 <bean> 태그와 동일한 역할
// @Controller : 프리젠테이션 레이어, 웹 어플리케이션에서 View 에서 전달된 웹 요청과 응답을 처리하는 클래스.(사용자의 입출력) ex) Controller Class
// @Service : 서비스 레이어, 비즈니스 로직을 가진 클래스.(사용자의 요청에 맞는 서비스를 제공) ex) Service Class
// @Repository : 퍼시스턴스(persistence)레이어, 영속성을 가지는 속성(파일, 데이터베이스)을 가진 클래스.(서비스의 데이터를 받는 부분) ex) Data Access Object Class
//  -> persistence layer : DB와 연결된 계층 | 영속성 : 데이터를 생성한 프로그램이 종료되어도 사라지지 않는 데이터의 특성
// Configuration : 빈을 등록하는 설정 클래스