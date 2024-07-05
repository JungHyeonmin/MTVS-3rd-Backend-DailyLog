package com.ohgiraffers.section01.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/showErrorPage")
public class ExceptionHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html; charset=UTF-8");

        Enumeration<String> attrName = req.getAttributeNames();
        while (attrName.hasMoreElements()) {
            System.out.println(attrName.nextElement());
        }

        Integer statusCode = (Integer) req.getAttribute("jakarta.servlet.error.status_code"); // Object 로 반환하기 때문에 다운 캐스팅을 해줘야한다.
        String message = (String) req.getAttribute("jakarta.servlet.error.message"); // Object 로 반환하기 때문에 다운 캐스팅을 해줘야한다.

        PrintWriter out = resp.getWriter();
        StringBuilder errorPage = new StringBuilder();
        errorPage.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("<h1>" + statusCode + "</h1>\n")
                .append("<h3>" + message + "</h3>\n")
                .append("</body>\n")
                .append("</html>\n");

        out.println(errorPage);

        out.close();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp); // doGet 으로 통합해서 메서드 생성
    }
}
