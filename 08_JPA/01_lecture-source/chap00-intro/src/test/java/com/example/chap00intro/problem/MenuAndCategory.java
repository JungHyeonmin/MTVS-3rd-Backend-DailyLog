package com.example.chap00intro.problem;

public class MenuAndCategory {

    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private Category Category;
    private String orderalbeStatus;

    public MenuAndCategory() {

    }

    public MenuAndCategory(int menuCode, String menuName, int menuPrice, int categoryCode, com.example.chap00intro.problem.Category category, String orderalbeStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        Category = category;
        this.orderalbeStatus = orderalbeStatus;
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

    public com.example.chap00intro.problem.Category getCategory() {
        return Category;
    }

    public void setCategory(com.example.chap00intro.problem.Category category) {
        Category = category;
    }

    public String getOrderalbeStatus() {
        return orderalbeStatus;
    }

    public void setOrderalbeStatus(String orderalbeStatus) {
        this.orderalbeStatus = orderalbeStatus;
    }

    @Override
    public String toString() {
        return "MenuAndCategory{" +
                "menuCode=" + menuCode +
                ", menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", Category=" + Category +
                ", orderalbeStatus='" + orderalbeStatus + '\'' +
                '}';
    }
}
