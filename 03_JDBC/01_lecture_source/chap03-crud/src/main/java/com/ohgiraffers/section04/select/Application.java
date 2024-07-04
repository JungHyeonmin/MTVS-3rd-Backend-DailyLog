package com.ohgiraffers.section04.select;

import com.ohgiraffers.model.dto.MenuDTO;
import com.ohgiraffers.section01.insert.MenuRegisterService;

import javax.swing.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

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
