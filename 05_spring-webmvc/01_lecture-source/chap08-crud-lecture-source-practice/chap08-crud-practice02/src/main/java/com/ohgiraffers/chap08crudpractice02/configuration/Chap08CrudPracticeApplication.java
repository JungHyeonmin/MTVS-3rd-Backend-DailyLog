package com.ohgiraffers.chap08crudpractice02.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// Mapper : 정의해놓은 sql 과 개발할 때 사용하는 메서드를 연결하고 결과 값을 정의해 놓은 타입으로 매핑 시켜주는 것
//          - 정의해높은 sql 과 개발할 때 사용하는 메서드를 연결하고 결과 값을 정의해놓은 타입으로 매핑시켜주는 것

@SpringBootApplication
@ComponentScan(basePackages = "com.ohgiraffers.chap08crudpractice02") // basePackages 로 설정된 경로에서 bean 스캔
// basePackages 로 설정된 경로에서 '@Mapper' 어노테이션이 붙은 인터페이스를 스캔하여 MyBatis 매퍼로 등록한다.
@MapperScan(basePackages = "com.ohgiraffers.chap08crudpractice02", annotationClass = Mapper.class)
public class Chap08CrudPracticeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap08CrudPracticeApplication.class, args);
    }

}
