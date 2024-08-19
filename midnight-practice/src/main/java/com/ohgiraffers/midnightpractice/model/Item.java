package com.ohgiraffers.midnightpractice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Embeddable
@Table(name = "tbl_item")
public class Item {
    @Id
    @Column(name = "ITEM_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemNo;

    @Column(name = "ITEM_NAME")
    private String ItemName;

    @Column(name = "ITEM_CATEGORY")
    private String itemCategory;

    @Column(name = "ITEM_INFO")
    private String itemInfo;

    @Column(name = "ITEM_PRICE")
    private Long itemPrice;

    public Item(String itemName, String itemCategory, String itemInfo, Long itemPrice) {
        this.ItemName = itemName;
        this.itemCategory = itemCategory;
        this.itemInfo = itemInfo;
        this.itemPrice = itemPrice;
    }

    public void setItemName(String ItemName) {
        this.ItemName = this.ItemName;
    }
}