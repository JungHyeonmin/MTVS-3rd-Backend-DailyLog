package com.ohgiraffers.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/response")
public class ResponseTestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        // 우리가 작성하는 문서는 html, 10버전부터 스트림 이후에 설정해도 되도록 변경되었다.
        resp.setContentType("text/html; charset=utf-8");
        System.out.println(resp.getContentType()); // null

        // Stream
        // out.println("hello world!!"); // out.println : 사용자의 브라우저에 출력 System.out.println : 콘솔창에 출력

        StringBuilder responseBuilder = new StringBuilder();
        responseBuilder.append("<!doctype html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("</head>\n")
                .append("<h1>안녕? servlet response</h1>\n")
                .append("<body>\n")
                .append("</body>\n")
                .append("</html>\n");

        // 스트림으로 내보내기
        out.println(responseBuilder); // 땜뀞? servlet response 로 나온다. -> 어떻게 반응하는지 알려주지 않아서 그렇다. (기본 설정 필요)

        // 무조건 외부자원을 닫자
        // out.flush(); // flush() : 다 차지않은 버퍼를 강제로 내보낼 수 있다. - 버퍼를 이용하면 무조건  사용한다.
        out.close(); //  하지만 close() 가 flush()의 역할도 한다. 확실하게 같이 써주면 좋다.
    }
}
