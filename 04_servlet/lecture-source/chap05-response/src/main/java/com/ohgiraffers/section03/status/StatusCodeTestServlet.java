package com.ohgiraffers.section03.status;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/status")
public class StatusCodeTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 톰캣의 에러 페이지는 정보가 노출되기 때문에 사용하면 안된다.

        // resp. sendError(404,"없는 페이지 입니다. 경로를 확인해주세요."); // 오류코드, 출력할 문장
        resp.sendError(500, "서버 내부 오류입니다. 서버 오류는 개발자의 잘못이고, 개발자는 여러분입니다.");
    }

}
