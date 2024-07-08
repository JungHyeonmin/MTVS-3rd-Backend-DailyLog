package com.ohgiraffers.section01.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandlerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);

        // resp.sendRedirect("redirect");

        // resp.sendRedirect("redirect?firstName = " + firstName + "&lastName = " + lastName);

        // 쿠키의 제약사항
        // 쿠키의 이름은 ascii 문자만을 사용해야 하며, 한 번 설정한 쿠키의 이름은 변경할 수 없다.
        // 쿠키의 이름에는 공백문자와 일부 특수문다를 사용할 수 없다.([] () = , " \ ? @ : ;)
        Cookie firstNameCookie = new Cookie("firstName", firstName);
        Cookie lastNameCookie = new Cookie("lastName", lastName);

        // 털려도 짧은 시간동안만 이용할 수 있도록 설정할때 사용한다.
        firstNameCookie.setMaxAge(60 * 60 * 24); // 하루를 만료 시간으로 두는 경우 예시

        resp.addCookie(firstNameCookie);
        resp.addCookie(lastNameCookie);

        resp.sendRedirect("redirect");
    }
}
