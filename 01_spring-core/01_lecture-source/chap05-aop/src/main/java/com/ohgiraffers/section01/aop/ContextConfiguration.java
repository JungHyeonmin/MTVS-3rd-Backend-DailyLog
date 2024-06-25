package com.ohgiraffers.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true) // Aspect 기능 활성화 // ()안은 항상 작성한다.
public class ContextConfiguration {

}
