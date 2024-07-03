package com.ohgiraffers.model.dto;

// rset 에 저장한 객체를 DTO 를 이용해서 저장한다.

public class MenuDTO {
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderalbeStatus;

    public MenuDTO(int menuCode, String menuName, int menuPrice, int categoryCode, String orderalbeStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderalbeStatus = orderalbeStatus;
    }

    public MenuDTO() {

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

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getOrderalbeStatus() {
        return orderalbeStatus;
    }

    public void setOrderalbeStatus(String orderalbeStatus) {
        this.orderalbeStatus = orderalbeStatus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderalbeStatus='" + orderalbeStatus + '\'' +
                '}';
    }
}
