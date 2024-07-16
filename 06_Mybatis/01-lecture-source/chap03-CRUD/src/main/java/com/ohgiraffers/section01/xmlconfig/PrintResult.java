package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

public class PrintResult {

    public void printMenuList(List<MenuDTO> menuList) {

        menuList.forEach(System.out::println);
    }

    // 실패 결과 출력
    public void printErrorMessage(String msg) {

        String errorMessage = "";
        switch (msg) {
            case "findAll":
                errorMessage = "메뉴 목록 조회를 실패하셨습니다.";
                break;
            case "findOne":
                errorMessage = "메뉴 상세 조회를 실패하셨습니다.";
                break;
            case "insert":
                errorMessage = "신규 메뉴 등록에 실패하셨습니다.";
                break;
            case "update":
                errorMessage = "메뉴 수정에 실패하셨습니다.";
                break;
            case "remove":
                errorMessage = "메뉴 삭제에 성공하셨습니다.";
                break;
        }

        System.out.println(errorMessage);
    }

    
    // 메뉴 출력
    public void printMenu(MenuDTO menu) {

        System.out.println(menu);
    }

    // 성공 결과 출력
    public void printSuccessMessage(String msg) {

        String successMessage = "";
        switch (msg) {
            case "insert":
                successMessage = "신규 메뉴 등록에 성공하셨습니다!";
                break;
            case "update":
                successMessage = "메뉴 수정에 성공하셨습니다.";
                break;
            case "remove":
                successMessage = "메뉴 삭제에 성공하셨습니다.";
                break;
        }

        System.out.println(successMessage);
    }
}