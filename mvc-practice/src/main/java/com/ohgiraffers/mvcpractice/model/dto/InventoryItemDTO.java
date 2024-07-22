package com.ohgiraffers.mvcpractice.model.dto;

public class InventoryItemDTO {

    private int inventoryPlayerNo;
    private int inventoryItemNo;
    private int inventoryAmount;
    private ItemDTO item;

    public InventoryItemDTO() {}

    public InventoryItemDTO(int inventoryPlayerNo, int inventoryItemNo, int inventoryAmount, ItemDTO item) {
        this.inventoryPlayerNo = inventoryPlayerNo;
        this.inventoryItemNo = inventoryItemNo;
        this.inventoryAmount = inventoryAmount;
        this.item = item;
    }

    public int getInventoryPlayerNo() {
        return inventoryPlayerNo;
    }

    public void setInventoryPlayerNo(int inventoryPlayerNo) {
        this.inventoryPlayerNo = inventoryPlayerNo;
    }

    public int getInventoryItemNo() {
        return inventoryItemNo;
    }

    public void setInventoryItemNo(int inventoryItemNo) {
        this.inventoryItemNo = inventoryItemNo;
    }

    public int getInventoryAmount() {
        return inventoryAmount;
    }

    public void setInventoryAmount(int inventoryAmount) {
        this.inventoryAmount = inventoryAmount;
    }

    public ItemDTO getItem() {
        return item;
    }

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "InventoryItemDTO{" +
                "inventoryPlayerNo=" + inventoryPlayerNo +
                ", inventoryItemNo=" + inventoryItemNo +
                ", inventoryAmount=" + inventoryAmount +
                ", item=" + item +
                '}';
    }
}
