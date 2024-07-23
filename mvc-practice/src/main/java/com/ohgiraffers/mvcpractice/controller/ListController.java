package com.ohgiraffers.mvcpractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {

    // 두번에 걸쳐서 접속
    @GetMapping("/list")
    public void userPage(){}
}
