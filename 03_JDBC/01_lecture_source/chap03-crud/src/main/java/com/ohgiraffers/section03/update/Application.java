package com.ohgiraffers.section03.update;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("바꾸고 싶은 메뉴의 이름을 입력하세요 : ");
        String menuName = sc.nextLine();

        System.out.print("바꿀 메뉴이름을 입력하세요 : ");
        String newMenuName = sc.nextLine();

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);

        MenuReplaceService menuReplaceService = new MenuReplaceService();
        if (menuReplaceService.replaceMenu(menu)) {
            System.out.println(menu.getMenuName() + "에서" + newMenuName + "로 변경되었습니다.");
        } else {
            System.out.println("변경을 실패했습니다.");
        }


    }
}
