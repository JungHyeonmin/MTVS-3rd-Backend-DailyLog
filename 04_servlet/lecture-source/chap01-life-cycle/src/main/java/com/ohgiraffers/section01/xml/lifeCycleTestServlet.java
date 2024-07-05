package com.ohgiraffers.section01.xml;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// HttpServlet 을 상속받아서 @Override 해서 servlet 으로 사용할 수 있다.
// servlet 은 TomCat 의 메서드를 오버라이딩 해서 커스텀해서 사용한다.
public class lifeCycleTestServlet extends HttpServlet {

    private int initCount = 1;
    private int getCount = 1;
    private int destroyCount = 1;


    // ctrl + o : 상속, 구현 가능한 메서드 목록 호출

    // 생명주기에 관련된 메서드 (init, doGet, destroy)

    // HttpServlet 에서 상속받는다.
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("xml 매핑 init() 메서드 호출 : " + initCount++);
    }

    // HttpServlet 에서 상속받는다.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("xml 매핑 doGet() 메서드 호출 : " + getCount++);
    }

    // 서비스도 doGet 처럼 동작 가능
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    // GenericServlet 에서 상속받는다.
    @Override
    public void destroy() {
        System.out.println("xml 매핑 destroy() 메서드 호출 : " + destroyCount++);
    }
}
