package com.ohgiraffers.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/formdata")
public class FormDataTestServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getCharacterEncoding());
        // req.setCharacterEncoding("UTF-8"); // 톰캣 10버전, 스프링 3버전 부터 자동 UTF-8로 변환해준다.

        String name = req.getParameter("name");
        System.out.println("name = " + name);

        Map<String, String[]> requestMap = req.getParameterMap();
        Set<String> keySet = requestMap.keySet();
        Iterator<String> keyIter = keySet.iterator();

        while (keyIter.hasNext()) {
            String key = keyIter.next();
            String[] values = requestMap.get(key); // 문자열 배열

            System.out.println("key = " + key);
            for (int i = 0; i < values.length; i++) {
                System.out.println("values = " + values[i]);
            }
        }

        // 원하는 목록만 따로 볼수있음
        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()) {
            System.out.println(names.nextElement());
        }
    }
}
