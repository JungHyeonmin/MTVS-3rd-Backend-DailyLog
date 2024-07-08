package com.ohgiraffers.section01.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");


        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        
        // session 을 이용한 값 전달 - session 사용시 관리자와 사용자 창을 서로 다른 플랫폼이나 시크릿 모드로 보여줘야 session 이 겹치는 일을 방지할 수 있다.
        HttpSession session = req.getSession();
        session.setAttribute("firstName", firstName);
        session.setAttribute("lastName", lastName);

        resp.sendRedirect("redirect");
    }
}
