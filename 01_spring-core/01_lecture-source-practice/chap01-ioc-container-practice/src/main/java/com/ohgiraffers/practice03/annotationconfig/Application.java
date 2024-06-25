package com.ohgiraffers.practice03.annotationconfig;

import com.ohgiraffers.common.BoardDAO;
import com.ohgiraffers.common.BoardDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application {
    public static void main(String[] args) {
        // ApplicationContext : 빈을 관리하는 스프링 컨테이너
        // AnnotationConfigApplicationContext : 설정된 bean 을 basepackage로 등록한 경로의 하위 폴더를 탐색한다. // (ContextConfiguration.class)를 basepackage로 함
        ApplicationContext context = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        // context.getBeanDefinitionNames() : 스프링 컨테이너에 등록된 빈 모두 출력 // 출력한 빈을 String 배열에 넣는다.
        String[] beanNames = context.getBeanDefinitionNames();

        // 반복문으로 전부 호출
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

        // boardDTO 에 책 추가 및 호출
        BoardDAO boardDAO = context.getBean("boardDAO", BoardDAO.class);
        System.out.println(boardDAO.selectBoard(1L));
        System.out.println(boardDAO.insertBoard(new BoardDTO(3L, "스프링 수업 엄청 기다렸어요!", "많은 걸 얻어 갈 수 있는 시간이 되면 좋겠어요", "봄이 올까요?ㅁ")));
        System.out.println(boardDAO.selectBoard(3L));
    }
}
