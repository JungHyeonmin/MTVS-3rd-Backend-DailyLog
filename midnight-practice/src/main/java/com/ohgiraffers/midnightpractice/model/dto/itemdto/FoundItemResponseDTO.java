package com.ohgiraffers.midnightpractice.model.dto.itemdto;

import com.ohgiraffers.midnightpractice.model.Item;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FoundItemResponseDTO {

    private String itemName;
    private String itemCategory;
    private String itemInfo;
    private Long itemPrice;


    public FoundItemResponseDTO(Item item) {
        this(
                item.getItemName(),
                item.getItemCategory(),
                item.getItemInfo(),
                item.getItemPrice()
        );
    }
}