package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {


        // 매개변수가 3개 이상으로 늘어나면 알아보기 힘들기 때문에 menuDTO 로 묶어서 전달한다.
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


        MenuDTO newMenu = new MenuDTO();

        newMenu.setMenuName(menuName);
        newMenu.setMenuPrice(menuPrice);
        newMenu.setCategoryCode(categoryCode);
        newMenu.setOrderalbeStatus(orderableStatus);

        MenuRegisterService menuRegisterService = new MenuRegisterService();
        if (menuRegisterService.registerMenu(newMenu)) {
            System.out.print("메뉴 등록에 성공하셨습니다!!");
        } else {
            System.out.print("메뉴 등록에 실패하셨습니다..");
        } 
    }
}
