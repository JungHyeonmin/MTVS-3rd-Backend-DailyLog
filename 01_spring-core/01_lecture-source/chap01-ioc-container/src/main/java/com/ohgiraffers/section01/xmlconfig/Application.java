package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        // xml spring config파일의 위치를 알려줘야 한다. ctrl + click 하면 해당 위치로 이동한다.
        // ApplicationContext : BeanFactory 를 확장한 IoC 컨테이너로
        // Bean 을 등록하고 관리하는 기능은 BeanFactory 와 동일하지만 스프링이 제공하는 각종 부가 기능을 추가로 제공한다.
        ApplicationContext context = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml"); // xml spring config파일의 위치를 알려줘야 한다.

        // MemberDTO member = (MemberDTO) context.getBean("member");
        // MemberDTO member = context.getBean(MemberDTO.class); // 타입으로 메타 데이터 가져오기, 1개만 가져올 수 있다.
        MemberDTO member = context.getBean("member", MemberDTO.class);

        System.out.println("member = " + member);
    }
}
