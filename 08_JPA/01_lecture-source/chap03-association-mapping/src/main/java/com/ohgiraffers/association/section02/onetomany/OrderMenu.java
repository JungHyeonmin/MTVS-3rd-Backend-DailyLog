package com.ohgiraffers.association.section02.onetomany;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// 한 페키지에 Entity 가 두개이상 생기는 것은 피해야한다.
@Entity
@Table(name = "TBL_ORDER_MENU")
public class OrderMenu {

    @EmbeddedId
    private OrderMenuPK orderMenuPK; // PK 클래스 생성 - 테이블 복합키 설정

    @Column(name = "ORDER_AMOUNT")
    private int orderAmount;

    public OrderMenu() {

    }

    public OrderMenu(OrderMenuPK orderMenuPK, int orderAmount) {
        this.orderMenuPK = orderMenuPK;
        this.orderAmount = orderAmount;
    }

    public OrderMenuPK getOrderMenuPK() {
        return orderMenuPK;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    @Override
    public String toString() {
        return "OrderMenu{" +
                "orderMenuPK=" + orderMenuPK +
                ", orderAmount=" + orderAmount +
                '}';
    }
}
