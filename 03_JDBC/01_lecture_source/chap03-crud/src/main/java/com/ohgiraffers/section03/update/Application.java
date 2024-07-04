package com.ohgiraffers.section03.update;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.Scanner;

// update 방법 : 코드 번호를 이용해서

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("바꾸고 싶은 메뉴의 코드를 입력하세요. : ");
        int menuCode = sc.nextInt();
        sc.nextLine();
        System.out.print("메뉴의 이름을 입력하세요. :");
        String menuName = sc.nextLine();

        System.out.print("메뉴의 가격을 입력하세요. : ");
        int menuPrice = sc.nextInt();

        System.out.print("카테고리 코드를 입력하세요. : ");
        int categoryCode = sc.nextInt();
        sc.nextLine();

        System.out.print("판매 상태를 입력하세요.(Y/N) : ");
        String orderableStatus = sc.nextLine();

        // 저장받을 객체를 생성
        MenuDTO newMenu = new MenuDTO();

        // setter 로 객체에 값 추가
        newMenu.setMenuCode(menuCode);
        newMenu.setMenuName(menuName);
        newMenu.setMenuPrice(menuPrice);
        newMenu.setCategoryCode(categoryCode);
        newMenu.setOrderalbeStatus(orderableStatus);

        // 서비스를 담당하는 클래스의 객체를 생성
        MenuReplaceService menuReplaceService = new MenuReplaceService();
        if (menuReplaceService.replaceMenu(newMenu)) {
            System.out.println("변경에 성공했습니다.");
        } else {
            System.out.println("변경에 실패했습니다.");
        }
    }
}
