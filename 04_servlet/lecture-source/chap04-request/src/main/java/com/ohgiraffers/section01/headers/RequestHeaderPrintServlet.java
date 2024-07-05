package com.ohgiraffers.section01.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/headers")
public class RequestHeaderPrintServlet extends HttpServlet {

    // request : 요청

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }

        System.out.println();

        System.out.println("accept : " + req.getHeader("accept"));
        // refer : 이전페이지에 어떤 경로로 요청이 들어왔는지 확인
        System.out.println("refer : " + req.getHeader("referer"));
        // user-agent : 인터넷 브라우저에서 우리가 입력한 정보들을 HTTP 요청으로 바꿔주는 일종의 툴
        System.out.println("user-agent : " + req.getHeader("user-agent"));

    }
}
