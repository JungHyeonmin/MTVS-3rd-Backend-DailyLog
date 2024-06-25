package com.ohgiraffers.common;

public class Beverage extends Product {

    private int capacity;

    public Beverage() {}

    public Beverage(String name, int price, int capacity) {
        super(name, price);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {

        return super.toString() + " " + this.capacity;
    }
}
