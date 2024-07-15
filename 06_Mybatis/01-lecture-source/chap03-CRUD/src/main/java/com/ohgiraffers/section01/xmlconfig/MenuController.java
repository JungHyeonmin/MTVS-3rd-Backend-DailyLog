package com.ohgiraffers.section01.xmlconfig;

import java.util.List;

// 컨트롤러의 역할
// 요청을 받기
// 요청을 받아서 비지니스 로직에 연결
// 콘솔에 응답 화면 만들기

public class MenuController {

    private final PrintResult printResult;
    private final MenuService menuService;

    public MenuController() {
        printResult = new PrintResult();
        menuService = new MenuService();
    }

    public void findAllMenus() {

        List<MenuDTO> menuList = menuService.findAllMenus();

        if (menuList != null) {
            printResult.printMenuList(menuList);
        } else {
            printResult.printErrorMessage("findAll");
        }
    }
}