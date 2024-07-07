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

@WebServlet("/request-service")
public class ServiceMethodTestServlet extends HttpServlet {

    // doGet() : HttpServlet 의 메서드 Get 방식에서 호출되는 메서드, 데이터가 URL 에 포함된다.
    // doPost() : HttpServlet 의 메서드 Post 방식에서 호출되는 메서드, 데이터가 HTML header 에 포함된다.
    // service() : HTTP 프로토콜을 사용해서 넘어온 자료들을 doGet() 메서드나 doPost() 메서드 를 호출하게 된다. // 메서드의 모든 HTTP 요청을 처리하는 메서드
    //             클라이언트로부터 넘겨진 자료의 method 를 보고 GET 이면, doGet 메서드를, Post 이면 doPost 메서드를 호출한다.
    //             위 두가지 메서드가 필요없이 그냥 출력을 내보내기만 한다면 service() 메서드를 오버라이딩한다.
    // Service 메서드가 없으면 부모의 service 메서드를 호출한다.
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service 메서드 호출...");

        HttpServletRequest request = (HttpServletRequest) req; // HttpServletRequest : 서블릿에 요청하는 객체
        HttpServletResponse response = (HttpServletResponse) res; // HttpServletResponse : 서블릿에서 응답하는 객체

        // getMethod() : HttpServletRequest 객체에서 사용 가능한 메서드, 현재 HTTP 요청을 문자열로 출력한다.
        String httpMethod = request.getMethod();
        System.out.println("httpMethod = " + httpMethod);

        // 만약 요청이 GET 인지 POST 인지에 따라서 doGet() 을 할것인지 doPost() 를 할것인지 판단한다.
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
