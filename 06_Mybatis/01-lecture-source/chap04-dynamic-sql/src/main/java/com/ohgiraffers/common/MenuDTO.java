package com.ohgiraffers.common;

public class MenuDTO {

    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int menuCategoryCode;

    public MenuDTO() {
    }

    public MenuDTO(int menuCode, String menuName, int menuPrice, int menuCategoryCode, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuCategoryCode = menuCategoryCode;
        this.orderableStatus = orderableStatus;
    }

    public int getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(int menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getMenuPrice() {
        return menuPrice;
    }

    public void setMenuPrice(int menuPrice) {
        this.menuPrice = menuPrice;
    }

    public int getMenuCategoryCode() {
        return menuCategoryCode;
    }

    public void setMenuCategoryCode(int menuCategoryCode) {
        this.menuCategoryCode = menuCategoryCode;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", menuCategoryCode=" + menuCategoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }

    private String orderableStatus;
}
