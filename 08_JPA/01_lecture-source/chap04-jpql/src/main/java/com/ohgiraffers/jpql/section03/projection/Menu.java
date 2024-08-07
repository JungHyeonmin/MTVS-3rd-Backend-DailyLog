package com.ohgiraffers.jpql.section03.projection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "Section03Menu")
@Table(name = "TBL_MENU")
public class Menu {

    @Id
    @Column(name = "MENU_CODE")
    private int menuCode;

    @Column(name = "MENU_NAME")
    private String menuName;

    @Column(name = "MENU_PRICE")
    private int price;

    @Column(name = "CATEGORY_CODE")
    private int categoryCode;

    @Column(name = "ORDERABLE_STATUS")
    private String orderableStatus;

    protected Menu() {
    }

    public int getMenuCode() {
        return menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", price=" + price +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
