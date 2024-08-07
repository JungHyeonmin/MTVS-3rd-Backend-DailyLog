package com.ohgiraffers.association.section01.manytoone;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_menu")
public class Menu {

    @Id
    private int menuCode;

    private String menuName;
    private int menuPrice;

    // Menu 가 Category 를 내부에 가지고 있으므로 Category 에 의존하고 있다. Category 는 내부에 없으므로 의존x
    @ManyToOne(fetch = FetchType.LAZY) // LAZY : 필요할 때 카테고리 테이블 조회, // EAGER : 모든 테이블 조회
    @JoinColumn(name = "CATEGORY_CODE")
    private Category category; // 다른 엔티티 추가
    private String orderableStatus;

    public int getMenuCode() {
        return menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public Category getCategory() {
        return category;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", category=" + category +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
