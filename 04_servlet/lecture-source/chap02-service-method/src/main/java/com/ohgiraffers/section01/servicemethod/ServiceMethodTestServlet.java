package com.ohgiraffers.section01.servicemethod;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

//
@WebServlet("/request-service") // /request-service URL 로 접속하면 이 서블릿 클래스가 반응한다.
public class ServiceMethodTestServlet extends HttpServlet {

    // Service 메서드가 없으면 부모의 service 메서드를 호출한다.
    @Override // service() 메소드에서는  request, response 요청 정보를 가지고 처리 로직을 거쳐 응답한다.
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service 메서드 호출...");

        // HttpServletRequest 는 ServletRequest 타입을 상속 받아 구현하였으며,
        // HTTP 프로토콜의 정보를 담고 있기 때문에 실제 사용 시에는 HttpServletRequest 타입으로 다운캐스팅해서 사용해야 한다.
        // HttpServletRequest : http 프로토콜의 request 정보를 서블릿에게 전달하기 위해 사용
        // HttpServletResponse : 요청을 보낸 클라이언트에게 응답을 보내기 위해 WAS 에서 생성되어 서블릿에게 전달됨
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;


        String httpMethod = request.getMethod();
        System.out.println("httpMethod = " + httpMethod);

        if ("GET".equals(httpMethod)) {
            doGet(request, response);
        } else if ("POST".equals(httpMethod)) {
            doPost(request, response);
        }

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메서드 호출...");


    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메서드 호출...");
    }

}
