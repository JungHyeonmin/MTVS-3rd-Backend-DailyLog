package com.ohgiraffers.association.section02.onetomany;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "tbl_order")
public class Order {

    @Id
    @Column(name = "ORDER_CODE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderCode;

    // 날짜와 시간을 분리하고 문자열로 선언한 이유는? 시간의 범위가 아닌 일치여부로 집계하기 위해서
    @Column(name = "ORDER_DATE")
    private String orderDate;

    @Column(name = "ORDER_TIME")
    private String orderTime;

    @Column(name = "TOTAL_ORDER_PRICE")
    private int totalOrderPrice;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_CODE", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private List<OrderMenu> orderMenus;

    public Order() {
    }

    public Order(LocalDate orderDate, LocalTime orderTime, int totalOrderPrice, List<OrderMenu> orderMenus) {

        this.orderDate = orderDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.orderTime = orderTime.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        this.totalOrderPrice = totalOrderPrice;
        this.orderMenus = orderMenus;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public int getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public List<OrderMenu> getOrderMenus() {
        return orderMenus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderCode=" + orderCode +
                ", orderDate='" + orderDate + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", totalOrderPrice=" + totalOrderPrice +
                ", orderMenus=" + orderMenus +
                '}';
    }
}