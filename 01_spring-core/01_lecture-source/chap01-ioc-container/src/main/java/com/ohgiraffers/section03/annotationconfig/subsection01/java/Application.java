package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class); // section02패키지와 헷살리지 않게 조심하기

        String[] beanNames = context.getBeanDefinitionNames();// 컨테이너 안에 있는 모든 빈을 배열형태로 이름을 나열, 탐색 범위는 하위 폴더만 탐색한다.
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);
        System.out.println(memberDAO.findMemberBySeq(1));
        System.out.println(memberDAO.save(new MemberDTO(3, "user03", "pass03", "신사임당")));
        System.out.println(memberDAO.findMemberBySeq(3));

    }
}
