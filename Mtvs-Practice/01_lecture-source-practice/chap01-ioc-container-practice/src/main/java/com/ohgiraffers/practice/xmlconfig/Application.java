package com.ohgiraffers.practice.xmlconfig;

import com.ohgiraffers.common.BoardDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        // ApplicationContext : 빈 객체의 생성, 초기화, 보관, 제거 등을 관리하는 스프링 컨테이너
        // GenericXmlApplicationContext : XML 파일(경로)로부터 정보를 읽어와 객체를 생성하고 초기화
        ApplicationContext context = new GenericXmlApplicationContext("com/ohgiraffers/practice01/xmlconfig/spring-context.xml");


        // getBean : 주어진 이름("board) 또는 타입(<T>)을 기반으로 등록된 빈 객체를 반환한다.

        // (BoardDTO)로 다운캐스팅 하는 이유 : 타입지정이 아닌 이름으로 빈 객체를 반환하는 경우에 Object 타입으로 반환되기 때문에 다운 캐스팅을 한다.
        BoardDTO boardDTO = (BoardDTO) context.getBean("board");
        System.out.println("boardDTO = " + boardDTO);

        // 이름과 타입을 같이 작성하면 다운캐스팅을 한 상태로 반환한다.
        BoardDTO board = (BoardDTO) context.getBean("board", BoardDTO.class);
        System.out.println("board = " + board);
    }
}
