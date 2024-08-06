package com.ohgiraffers.mapping.section02.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

// Price 클래스를 따로 만들어서 비슷한 로직을 모아서 정리할 수 있다.

// 어딘가에 포함될 수 있다는 것을 알려주는 어노테이션
@Embeddable
public class Price {

    @Column(name = "REGULAR_PRICE")
    private int regularPrice;

    @Column(name = "DISCOUNT_RATE")
    private double discountRate;

    @Column(name = "SELL_PRICE")
    private int sellPrice;

    protected Price() {
    }

    // 음수로 들어오면 안되기때문에 체크하는 메서드
    public Price(int regularPrice, double discountRate) {
        validateNegativePrice(regularPrice);
        validateNegativeDiscountRate(discountRate);

        this.regularPrice = regularPrice;
        this.discountRate = discountRate;
        this.sellPrice = calcSellPrice(regularPrice, discountRate);

    }



    // db 쪽에서 처리하는 것이 아니라 java 에서 처리하는 방법이 객체지향의 방식!

    private int calcSellPrice(int regularPrice, double discountRate) {

        return (int) (regularPrice - (regularPrice * discountRate));
    }


    private void validateNegativePrice(int regularPrice) {

        if (regularPrice < 0) {
            throw new IllegalArgumentException("가격은 음수일 수 없습니다.");
        }
    }

    private void validateNegativeDiscountRate(double discountRate) {

        if (discountRate < 0) {
            // 파라미터 에러는 대부분 IllegalArgumentException Error 를 발생시킨다.
            throw new IllegalArgumentException("할인율은 음수일 수 없습니다.");
        }
    }

    public int getRegularPrice() {
        return regularPrice;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    @Override
    public String toString() {
        return "Price{" +
                "regularPrice=" + regularPrice +
                ", discountRate=" + discountRate +
                ", sellPrice=" + sellPrice +
                '}';
    }
}
