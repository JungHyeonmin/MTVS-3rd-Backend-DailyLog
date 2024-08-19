package com.ohgiraffers.securitysession.user.controller;

import com.ohgiraffers.securitysession.user.model.dto.SignupDTO;
import com.ohgiraffers.securitysession.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/signup")
    public void signup(){

    }

    @PostMapping("/signup")
    public ModelAndView signup(@ModelAttribute SignupDTO signupDTO, ModelAndView mv){

        Integer result = memberService.regist(signupDTO);
        String message = null;
        if(result == null ){
            message ="중복회원이 존재합니다.";
        }else if(result == 0) {
            message="서버에서 오류가 발생하였습니다.";
            mv.setViewName("user/signup");
        }else if(result >= 1){
            message = "회원가입이 완료되었습니다.";
            mv.setViewName("auth/login");
        }

        mv.addObject("message", message);

        return mv;
    }

}
