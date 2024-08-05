package com.ohgiraffers.persistence.section03.entity;

import javax.persistence.*;

@Entity(name = "Section03Menu")
@Table(name = "tbl_menu")
public class Menu {

    @Id
    @Column(name = "menu_code")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int menuCode;

    @Column(name = "menu_name")
    private String menuName;

    @Column(name = "menu_price")
    private int menuPrice;

    @Column(name = "category_code")
    private int categoryCode;

    @Column(name = "orderable_status")
    private String orderableStauts;

    public Menu() {

    }

    public Menu(String menuName, int menuPrice, int categoryCode, String orderableStauts) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStauts = orderableStauts;
    }

    public Menu(int menuCode, String menuName, int menuPrice, int categoryCode, String orderableStauts) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStauts = orderableStauts;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStauts='" + orderableStauts + '\'' +
                '}';
    }

    public String getMenuName() {
        return this.menuName;
    }

    public int getMenuPrice() {
        return this.menuPrice;
    }

    public int getCategoryCode() {
        return this.categoryCode;
    }

    public String getOrderalbeStatus() {
        return this.orderableStauts;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }
}
