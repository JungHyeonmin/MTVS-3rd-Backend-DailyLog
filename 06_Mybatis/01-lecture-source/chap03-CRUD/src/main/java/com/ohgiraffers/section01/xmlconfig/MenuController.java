package com.ohgiraffers.section01.xmlconfig;

import java.util.List;
import java.util.Map;

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

    // 모든 메뉴를 조회하는 메서드
    public void findAllMenus() {

        List<MenuDTO> menuList = menuService.findAllMenus();

        if (menuList != null) {
            printResult.printMenuList(menuList);
        } else {
            printResult.printErrorMessage("findAll");
        }
    }

    // 메뉴 1개를 조회하는 메서드
    public void findMenuByMenuCode(Map<String, String> parameter) {

        int menuCode = Integer.parseInt(parameter.get("menuCode"));

        MenuDTO menu = menuService.findMenuByMenuCode(menuCode);

        if (menu != null) {
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage("findOne");
        }
    }

    // 추가 메서드
    public void registMenu(Map<String, String> parameter) {

        int menuCode = Integer.parseInt(parameter.get("menuCode"));
        String menuName = parameter.get("menuName");
        int menuPrice = Integer.parseInt(parameter.get("menuPrice"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO();
        menu.setMenuCode(menuCode);
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);

        if (menuService.registMenu(menu)) {
            printResult.printSuccessMessage("insert");
        } else {
            printResult.printErrorMessage("insert");
        }
    }

    // 수정하는 메서드 - // 수정하려고 하는 메뉴의 코드와 수정하려는 값을 HashMap(parameter)으로 전달
    public void modifyMenu(Map<String, String> parameter) {

        // HashMap 인 parameter 에 저장된 값을 지역변수에 전달
        int menuCode = Integer.parseInt(parameter.get("menuCode"));
        String menuName = parameter.get("menuName"); // get() : Map 의 값을 가져오는 메서드 (menuName 이라는 키의 값을 가져온다.)
        int menuPrice = Integer.parseInt(parameter.get("menuPrice"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO menu = new MenuDTO(); // 여러개의 값을 전달하기 때문에 DTO 로 만들어서 전달

        menu.setMenuCode(menuCode);
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);

        // 성공, 실패했을 때 출력하는 문구
        if (menuService.modifyMenu(menu)) {
            printResult.printSuccessMessage("update");
        } else {
            printResult.printErrorMessage("update");
        }
    }

    public void removeMenu(Map<String, String> parameter) {

        int menuCode = Integer.parseInt(parameter.get("menuCode"));

        if (menuService.removeMenu(menuCode)) {
            printResult.printSuccessMessage("remove");
        } else {
            printResult.printErrorMessage("remove");
        }
    }
}