package com.ohgiraffers.chap08crudtest.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(basePackages = "com.ohgiraffers.chap08crudtest", annotationClass = Mapper.class)
@ComponentScan(basePackages = "com.ohgiraffers.chap08crudtest")
@SpringBootApplication
public class Chap08CrudTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Chap08CrudTestApplication.class, args);
    }

}
