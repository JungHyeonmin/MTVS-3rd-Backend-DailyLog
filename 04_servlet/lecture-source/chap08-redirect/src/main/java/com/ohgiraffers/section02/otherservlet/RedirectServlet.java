package com.ohgiraffers.section02.otherservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// forward -> get 요청은 get 으로 post 요청은 post 로 forward 한다.
// ⭐ redirect -> get, post 오청 전부 get 으로 redirect 한다..⭐
// 브라우저를 이용해서 로케이션 헤더에 URL 로 요청하고 url 을 그대로 복붙하기 때문에 get 으로 한다.

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("이 서블릿으로 redirect 성공!");


    }
}
