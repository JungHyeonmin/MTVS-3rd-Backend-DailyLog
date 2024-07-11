package com.ohgiraffers.handlermethod;


// 테이블은 화면단위로 받고, 요청과 응답으로 나눠서 용도에 맞고 명확하게 만든다.
// DTO 는 네이밍 규칙이 있고 규칙을 지켜야 한다.
public class MenuDTO {
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderAbleStatus;

    public MenuDTO() { // 기본 생성자를 작성하지 않으면 아무런 값을 입력하지 않았을 때 에러가 발생한다.
    }

    public MenuDTO(String menuName, int menuPrice, int categoryCode, String orderAbleStatus) {
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderAbleStatus = orderAbleStatus;
    }

    // getter 와 setter 모두 규약대로 표현하는 것이 좋다.
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

    public String getOrderAbleStatus() {
        return orderAbleStatus;
    }

    public void setOrderAbleStatus(String orderAbleStatus) {
        this.orderAbleStatus = orderAbleStatus;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuName='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderAbleStatus='" + orderAbleStatus + '\'' +
                '}';
    }
}
