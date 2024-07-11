package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    /**
     * 뷰 리졸버(뷰 해석기) - prefix/suffix 를 이용해서 뷰의 이름을 대응시킨다.
     * prefix = "templates";
     * suffix = ".html"
     *
     * request.getRequestDispatcher(prefix + 리턴한 문자열 + suffix).forward(req,res);
     *
     * return "redirect:경로" : forward 방식 대신 redirect 기술을 사용한다.
     * 
     * flashAttribute : 잠깐 쓰는 용도로 사용
     */

    // root 로 연결하기 (자주 사용하는 기술임)
    @RequestMapping(value = {"/", "/main"})
    public String main() {
        return "main"; // Get/Post, 어떤 URL 이던지 무조건 main 페이지를 보여줘라
    }

}
