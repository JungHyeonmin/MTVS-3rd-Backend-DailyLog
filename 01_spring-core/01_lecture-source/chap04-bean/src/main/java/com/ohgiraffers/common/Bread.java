package com.ohgiraffers.common;

import java.util.Date;

public class Bread extends Product {

    private java.util.Date bakedDate;

    public Bread() {
    }

    // 인스턴스는 Bread, Product, Object 총 3개가 만들어진다.
    public Bread(String name, int price, java.util.Date baedDate) {
        super(name, price); // 부모 생성자를 호출, 부모 필드 초기화 모조건 맨 처음에 사용해야 함
        this.bakedDate = baedDate;
    }

    public Date getBakedDate() {
        return bakedDate;
    }

    public void setBakedDate(Date bakedDate) {
        this.bakedDate = bakedDate;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.bakedDate;
        // return this.getName() + " " + super.getPrice() + " " + this.bakedDate; // 의미는 같댜.
    }
    // this : Bread로 생성된 인스턴스의 주소 (= 본인 인스턴스 주소)
    // 생략시 부모의 메서드라도 자동으로 this를 붙여준다.
}