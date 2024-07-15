package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class PrintResult {

    public void printMenuList(List<MenuDTO> menuList) {

        menuList.forEach(System.out::println);
    }

    public void printErrorMessage(String msg) {

        String errorMessage = "";
        switch (msg) {
            case "findAll": errorMessage = "메뉴 목록 조회를 실패하셨습니다."; break;
        }

        System.out.println(errorMessage);
    }
}