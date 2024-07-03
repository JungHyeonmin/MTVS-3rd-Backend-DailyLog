package com.ohgiraffers.section02.delete;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴의 이름을 입력하세요 : ");
        String menuName = sc.nextLine();

        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);

        MenuDeleteService menuDeleteService = new MenuDeleteService();
        if (menuDeleteService.deleteMenu(menu)) {
            System.out.print("메뉴 등록에 삭제하셨습니다!!");
        } else {
            System.out.print("메뉴 등록에 삭제에 실패하셨습니다..");
        }
    }
}
