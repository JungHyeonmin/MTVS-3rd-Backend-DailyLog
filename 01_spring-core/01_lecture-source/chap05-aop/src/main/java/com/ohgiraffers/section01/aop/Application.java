package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.ohgiraffers.section01.aop");

        MemberService memberService = (MemberService) context.getBean("memberService");

        System.out.println("\nfindAllMembers ============================");
        System.out.println(memberService.findAllMembers());

        System.out.println("\nfindMemberById ============================");
        System.out.println(memberService.findMemberById(1L));
    }
}
