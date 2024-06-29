package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * DI(Dependency Injection, 의존성 / 주입) 이란?
 * 
 * 의존성 주입은 객체가 필요로 하는 의존 객체를 컨테이너에서 제공(주입)하는 방식으로, 객체 간의 결합도를 낮추는 데 도움을 줍니다.
 *
 * 왜냐하면 의존성 주입을 통해 객체는 자신이 사용할 의존 객체를 직접 생성하지 않고,
 * 외부에서 생성된 객체를 주입받기 때문입니다. 이로 인해 객체는 자신의 구현에만 집중할 수 있으며, 변경에 유연하게 대응할 수 있습니다.
 *
 *
 * 이를 통해 객체 간의 결합도를 낮출 수 있으며 이로 인해 유지보수성과 유연성이 증가한다.
 *
 * 의존성이 높다는 것은 한 객체가 변경되면 이에 존재하는 다른 객체들도 함께 변경되어야 한다는 것을 의미한다.
 * 이처럼 객체 간의 의존 관계가 강하게 묶여있을 때 결합도가 높다고 표현한다. 이로 인해 유지보수석와 유연성이 저하될 수 있다.
 *
 * DI는 객체 간의 `의존 관계`를 빈 설정 정보를 바탕으로 컨테이너가 자동적으로 연결해주는 것이다.
 * 이를 통해 객체 간의 `결합도`를 낮출 수 있으며 이로 인해 `유지보수성`과 `유연성`이 증가한다.
 *
 * - XML 빈 설정 시에는 `<constructor-args>` 또는 `<property>` 태그의 `ref` 속성에 의존성 주입할 bean의 이름을 설정한다.
 * - Java 빈 설정 시에는 `생성자`, `setter 메소드`의 인자 값으로 의존성 주입할 bean의 메소드 호출 반환 값을 전달한다.
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
