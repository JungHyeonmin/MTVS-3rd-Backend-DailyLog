package com.ohgiraffers.mvcpractice.model.dto;

public class ItemDTO {
    private int itemNo;
    private String itemName;
    private String itemCategory;
    private String itemDescription;
    private int itemPrice;

    public ItemDTO(){}

    public ItemDTO(int itemNo, String itemName, String itemCategory, String itemDescription, int itemPrice) {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "ItemDTO{" +
                "itemNo=" + itemNo +
                ", itemName='" + itemName + '\'' +
                ", itemCategory='" + itemCategory + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
