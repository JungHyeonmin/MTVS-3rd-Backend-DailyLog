package com.ohgiraffers.securitysession.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    /*
     * 기본 요청시 페이지 이동을 위한 컨트롤러
     * */
    @GetMapping("/")
    public String root(){
        return "index";
    }

    /*
     * 관리자 권한 설정 체크를 위한 서블릿이다.
     */
    @GetMapping("/admin/page")
    public ModelAndView admin(ModelAndView mv){
        mv.setViewName("admin/admin");
        return mv;
    }

    /*
     * 유저 권한 설정 체크를 위한 서블릿이다.
     */
    @GetMapping("/user/page")
    public ModelAndView user(ModelAndView mv){
        mv.setViewName("user/user");
        return mv;
    }
}
