package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        // GenericXmlApplicationContext : xml 인지 확인하기 Application - x
        // ApplicationContext : BeanFactory 를 확장한 IoC 컨테이너로 Bean 을 등록하고 관리하는 기능은 BeanFactory 와 동일하지만
        // 스프링이 제공하는 각종 부가 기능을 추가로 제공한다.
        ApplicationContext context =
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        Member member = context.getBean("member", Member.class); // getBean() : 컨테이너에서 bean 가져오기

        System.out.println(member.getPersonalAccount().deposit(10000));
        System.out.println(member.getPersonalAccount().getBalance());
        System.out.println(member.getPersonalAccount().withdraw(5000));
        System.out.println(member.getPersonalAccount().getBalance());


    }
}
