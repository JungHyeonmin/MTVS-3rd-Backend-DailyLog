package com.ohgiraffers.section02.annotation;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Annotation 의 장점
 *      서블릿을 개발할 때 클래스 바로 윗쪽에 어노테이션만 추가하면 되므로 간편하다.
 *              단점
 *      별도의 문서 등으로 관리하지 않으면 시스템의 모든 서블릿 매핑 정보를 한눈에 볼 수 없다.
 */

// @WebServlet : 어노테이션으로 Servlet Mapping 하는 방법, 클라이언트가 "annotation-lifecycle"로 URL 접속을 하면 이 서블릿 클래스로 매핑해준다.
@WebServlet(value = "/annotation-lifecycle")
public class LifeCycleTestServlet extends HttpServlet {

    private int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("annotation 매핑 init() 메서드 호출 : " + initCount++);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("annotation 매핑 service() 메서드 호출 : " + serviceCount++);
    }

    @Override
    public void destroy() {
        System.out.println("annotation 매핑 destroy() 메서드 호출 : " + destroyCount++);
    }


}
