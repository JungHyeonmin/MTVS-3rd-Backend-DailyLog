package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        // DAO : jdbc 에 해당하는 코드만 넣는다.

        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴의 이름을 입력하세요 : ");
        String menuName = sc.nextLine();

        System.out.print("메뉴의 가격을 입력하세요 : ");
        int menuPrice = sc.nextInt();

        System.out.print("카테고리 코드를 입력하세요 : ");
        int categoryCode = sc.nextInt();
        sc.nextLine();

        System.out.print("판매 상태를 입력하세요(Y/N) : ");
        String orderableStatus = sc.nextLine();


        MenuDTO menu = new MenuDTO();
        menu.setMenuName(menuName);
        menu.setMenuPrice(menuPrice);
        menu.setCategoryCode(categoryCode);
        menu.setOrderalbeStatus(orderableStatus);

        MenuRegistService menuRegistService = new MenuRegistService();
        if (menuRegistService.registMenu(menu)) {
            System.out.print("메뉴 등록에 성공하셨습니다!!");
        } else {
            System.out.print("메뉴 등록에 실패하셨습니다..");
        } 
    }
}
