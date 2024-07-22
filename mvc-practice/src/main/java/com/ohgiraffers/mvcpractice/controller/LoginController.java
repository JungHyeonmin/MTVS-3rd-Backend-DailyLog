package com.ohgiraffers.mvcpractice.controller;

import com.ohgiraffers.mvcpractice.model.dto.PlayerDTO;
import com.ohgiraffers.mvcpractice.model.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * Session 이란?
 * 클라이언트로부터 오는 일련의 요청을 하나의 상태로 보고 그 상태를 일정하게 유지하는 기술
 * 클라이언트가 웹 서버에 접속해있는 상태가 하나의 단워
 */

// @SessionAttribute  : 컨트롤러 밖에서 생성된 Session 값에 접근
// @SessionAttributes : 컨트롤러에서 다루는 객체를 세션에 넣어 공유


@Controller
@SessionAttributes("loginPlayer") // Model 정보를 HTTP Session 에 저장해주는 어노테이션
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    
     // 로그인
    @PostMapping("/login")
    public String login(PlayerDTO playerDTO, Model model) {

        PlayerDTO loginPlayer = loginService.checkPlayer(playerDTO);

        System.out.println(loginPlayer); // 확인용
        
        model.addAttribute("loginPlayer", loginPlayer); // loginPlayer : Session 에 올리는 이름

        return "/list";
    }

    
    // 로그아웃
    @GetMapping("/index")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();

        return "/";
    }
}
