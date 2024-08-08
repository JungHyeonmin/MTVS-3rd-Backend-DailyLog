package com.ohgiraffers.jpql.section06.join;

import jakarta.persistence.*;

@Entity(name="Section06Menu")
@Table(name="TBL_MENU")
public class Menu {

    @Id
    @Column(name="MENU_CODE")
    private int menuCode;

    @Column(name="MENU_NAME")
    private String menuName;

    @Column(name="MENU_PRICE")
    private int menuPrice;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="CATEGORY_CODE")
    private Category category;

    @Column(name="ORDERABLE_STATUS")
    private String orderableStatus;

    protected Menu() {}

    public Menu(int menuCode, String menuName, int menuPrice, Category category, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.category = category;
        this.orderableStatus = orderableStatus;
    }

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