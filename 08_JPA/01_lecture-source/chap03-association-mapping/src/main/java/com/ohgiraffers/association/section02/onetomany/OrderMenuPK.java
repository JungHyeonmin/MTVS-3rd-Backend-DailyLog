package com.ohgiraffers.association.section02.onetomany;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable // implements Serializable 필수!!
public class OrderMenuPK implements Serializable {

    @Column(name = "ORDER_CODE")
    private int orderCode;

    @Column(name = "MENU_CODE")
    private int menuCode;

    public OrderMenuPK() {
    }


    public OrderMenuPK(int orderCode, int menuCode) {
        this.orderCode = orderCode;
        this.menuCode = menuCode;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public int getMenuCode() {
        return menuCode;
    }

    @Override
    public String toString() {
        return "OrderMenuPK{" +
                "orderCode=" + orderCode +
                ", menuCode=" + menuCode +
                '}';
    }
}
