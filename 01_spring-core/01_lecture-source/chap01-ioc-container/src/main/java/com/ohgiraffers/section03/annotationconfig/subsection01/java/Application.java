package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        // ApplicationContext : BeanFactory 를 확장한 IoC 컨테이너로
        // Bean 을 등록하고 관리하는 기능은 BeanFactory 와 동일하지만 스프링이 제공하는 각종 부가 기능을 추가로 제공한다.
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class); // section02패키지와 헷살리지 않게 조심하기

        // getBeanDefinitionNames() : 빈 컨테이너 안의 빈들의 이름을 배열로 반환한다.
        String[] beanNames = context.getBeanDefinitionNames();// 컨테이너 안에 있는 모든 빈을 배열형태로 이름을 나열, 탐색 범위는 하위 폴더만 탐색한다.
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        System.out.println();

        //
        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);
        System.out.println(memberDAO.findMemberBySeq(1));
        System.out.println(memberDAO.save(new MemberDTO(3, "user03", "pass03", "신사임당")));
        System.out.println(memberDAO.findMemberBySeq(3));

    }
}
