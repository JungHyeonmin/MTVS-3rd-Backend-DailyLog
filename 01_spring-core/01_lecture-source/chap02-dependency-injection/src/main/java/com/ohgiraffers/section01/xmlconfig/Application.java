package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * DI(Dependency Injection, 의존성 / 주입) 이란?
 *
 * 객체 간의 의존 관계를 빈 설정 정보를 바탕으로 컨테이너가 자동적으로 연결해주는 것을 말한다.
 * 이를 통해 객체 간의 결합도를 낮출 수 있으며 이로 인해 유지보수성과 유연성이 증가한다.
 *
 * 의존성이 높다는 것은 한 객체가 변경되면 이에 존재하는 다른 객체들도 함께 변경되어야 한다는 것을 의미한다.
 * 이처럼 객체 간의 의존 관계가 강하게 묶여있을 때 결합도가 높다고 표현한다. 이로 인해 유지보수석와 유연성이 저하될 수 있다.
 */

public class Application {
    public static void main(String[] args) {
        // ApplicationContext : BeanFactory 를 확장한 IoC 컨테이너로 Bean 을 등록하고 관리하는 기능은 BeanFactory 와 동일하지만
        // 스프링이 제공하는 각종 부가 기능을 추가로 제공한다.

        /* XML 설정 파일을 기반(GenericXmlApplicationContext)으로 ApplicationContext 객체 생성 */
        ApplicationContext context =
                new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");

        // id(member)를 이용해서 빈을 호출하고 Member 클래스로 캐스팅
        Member member = context.getBean("member", Member.class); // getBean() : 컨테이너에서 bean 가져오기

        System.out.println(member.getPersonalAccount().deposit(10000));
        System.out.println(member.getPersonalAccount().getBalance());
        System.out.println(member.getPersonalAccount().withdraw(5000));
        System.out.println(member.getPersonalAccount().getBalance());


    }
}
