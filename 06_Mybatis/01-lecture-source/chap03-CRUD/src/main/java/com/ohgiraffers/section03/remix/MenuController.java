package com.ohgiraffers.section03.remix;

import java.util.List;
import java.util.Map;

public class MenuController {

    private final PrintResult printResult;
    private final MenuService menuService;

    public MenuController() {
        printResult = new PrintResult();
        menuService = new MenuService();
    }

    public void findAllMenus() {

        List<MenuDTO> menuList = menuService.findAllMenus();

        if(menuList != null) {
            printResult.printMenuList(menuList);
        } else {
            printResult.printErrorMessage("findAll");
        }
    }

    public void findMenuByMenuCode(Map<String, String> stringStringMap) {
    }

    public void registMenu(Map<String, String> stringStringMap) {
    }

    public void modifyMenu(Map<String, String> stringStringMap) {
    }

    public void removeMenu(Map<String, String> stringStringMap) {
    }
}