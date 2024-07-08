package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        System.out.println("session.getId() = " + session.getId());

        System.out.println("session default 유지시간 : " + session.getMaxInactiveInterval());
        session.setMaxInactiveInterval(60 * 10); // session 만료시간을 10분을 설정

        // session 강제 만료 - 로그 아웃 방법 : 1. session invalidate(), session 을 null 값으로 변경, 만료시간 설정
        //session.invalidate();

        String firstName = session.getAttribute("firstName").toString();
        String lastName = (String) session.getAttribute("lastName"); // toString, 다운캐스팅 둘다 되지만 다운캐스팅을 권장한다. (문자열이 저장될거란 보장이 없으니까)

        System.out.println("session firstName = " + firstName);
        System.out.println("session lastName = " + lastName);
    }
}
