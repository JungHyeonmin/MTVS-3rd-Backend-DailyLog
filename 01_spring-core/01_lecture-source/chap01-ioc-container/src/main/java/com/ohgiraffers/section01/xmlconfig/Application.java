package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {

        // ApplicationContext : BeanFactory 를 확장한 IoC 컨테이너로
        // Bean 을 등록하고 관리하는 기능은 BeanFactory 와 동일하지만 스프링이 제공하는 각종 부가 기능을 추가로 제공한다.

        // GenericXmlApplicationContext : Spring IoC Container 중 하나이다. XML 형태의 Configuration Metadata 를 사용하며 Bean 을 생성한다.
        // 생성자에 XML 설정 메타 정보(파일이 저장되어 있는 경로로 작성)를 인자로 전달한다

        // XML Spring 설정 파일의 위치를 지정한다.
        ApplicationContext context = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml"); // xml spring config 파일의 위치를 알려줘야 한다.

        // MemberDTO member = (MemberDTO) context.getBean("member");
        // MemberDTO member = context.getBean(MemberDTO.class); // 타입으로 메타 데이터 가져오기, 1개만 가져올 수 있다.

        // context : GenericXmlApplicationContext 로 만든 스프링 컨테이너를 이용할 수 있도록 참조한다.
        // getBean : GenericXmlApplicationContext 의 메서드 Bean 의 정보를 가져온다.

        // XML 설정 파일에서 "member"라는 이름의 빈을 가져와서 MemberDTO 타입의 객체로 캐스팅한다.
        MemberDTO member = context.getBean("member", MemberDTO.class);

        // 가져온 빈 객체를 출력한다.
        System.out.println("member = " + member);
    }
}
