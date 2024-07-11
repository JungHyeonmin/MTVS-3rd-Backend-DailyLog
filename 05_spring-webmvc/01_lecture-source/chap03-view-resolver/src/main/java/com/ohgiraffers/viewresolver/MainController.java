package com.ohgiraffers.viewresolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    // root 로 연결하기 (자주 사용하는 기술임)
    @RequestMapping(value = {"/", "/main"})
    public String main() {
        return "main"; // Get/Post, 어떤 URL 이던지 무조건 main 페이지를 보여줘라
    }
}
