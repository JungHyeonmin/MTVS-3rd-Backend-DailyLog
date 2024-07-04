package com.ohgiraffers.section04.select;

import com.ohgiraffers.model.dto.MenuDTO;
import com.ohgiraffers.section01.insert.MenuRegisterService;

import javax.swing.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /**
         * nextInt() 메서드와 nextLine() 메서드를 연달아 사용하는 경우,
         * nextInt() 메서드 후에 남아있는 개행 문자로 인해 nextLine() 메서드가 예상치 못하게 동작할 수 있습니다.
         * 이를 해결하기 위해서는 nextInt() 메서드 후에 nextLine() 메서드를 한 번 더 호출하여 개행 문자를 소비하면 됩니다.
         */
        System.out.print("조회하고 싶은 메뉴의 이름을 입력하세요 : ");
        String menuName = sc.nextLine();

        // 저장받을 객체를 생성
        MenuDTO menu = new MenuDTO();

        // setter 로 객체에 값 추가
        menu.setMenuName(menuName);


        MenuSelectService menuSelectionManager = new MenuSelectService();

        if (menuSelectionManager.selectMenu(menu)) {
            System.out.print("메뉴 조회에 성공하셨습니다!!");
        } else {
            System.out.print("메뉴 조회에 실패하셨습니다..");
        }
    }
}
