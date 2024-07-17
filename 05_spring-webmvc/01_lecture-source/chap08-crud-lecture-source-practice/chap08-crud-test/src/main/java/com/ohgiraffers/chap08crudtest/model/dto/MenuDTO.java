package com.ohgiraffers.chap08crudtest.model.dto;

public class MenuDTO {
    private int code;
    private String name;
    private int price;
    private String category;
    private String orderable;

    public MenuDTO() {
    }

    public MenuDTO(int code, String name, int price, String category, String orderable) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.category = category;
        this.orderable = orderable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOrderable() {
        return orderable;
    }

    public void setOrderable(String orderable) {
        this.orderable = orderable;
    }

    @Override
    public String toString() {
        return "MenuDTO{" +
                "code=" + code +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", orderable='" + orderable + '\'' +
                '}';
    }
}
