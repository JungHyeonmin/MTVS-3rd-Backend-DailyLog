package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.ohgiraffers") // scan 범위 설정(base package 설정 - com.ohgiraffers 하위 폴더 전부 탐색) // memberDAO도 빈 목록에 생긴다.
public class ContextConfiguration {


}
