package com.ohgiraffers.section01.forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/forward")
public class ReceiveInformationServlet extends HttpServlet {

    // 정보를 header 로 전달하는 방법
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // 서블릿이 하는 역할
        // 1. 요청 정보 받기
        // 2. 비지니스 로직 처리
        // 3. 응답 내보내기

        // <form> 태그로 전달받은 속성과 값을 이용해서 속성안의 값을 문자열에 넣어서 확인한다.
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");

        System.out.println("userId = " + userId);
        System.out.println("password = " + password);

        String nickName = " ";
        if (userId != null && password != null) {
            nickName = "홍길동";
        }

        //req 의 setAttribute 로 값을 저장하고 전달 가능하다. ctrl + P 로 어떤 값이 들어갈 수 있는지 확인해봐!
        req.setAttribute("nickName", nickName); // 깊은 방식으로 넣는다. 얕은 방식은 주소 추적이 복잡해..

        // print 라는 주소를 가진 서블릿에 값을 전달해서 응답한다. - Spring 에서는 return print 하면 끝난다.. - 백그라운드에서 개념을 이해 해!
        RequestDispatcher rd = req.getRequestDispatcher("print");
        rd.forward(req, resp);
    }
}
