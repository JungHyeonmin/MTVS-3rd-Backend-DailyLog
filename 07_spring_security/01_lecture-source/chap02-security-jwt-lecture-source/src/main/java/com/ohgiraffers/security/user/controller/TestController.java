package com.ohgiraffers.security.user.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@PreAuthorize("hasAuthority('USER')")
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @PostMapping("/test")
    public String test2(){
        return "test";
    }
}
