package com.ohgiraffers.midnightpractice.model.dto.itemdto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemRegistRequestDTO {

    private String itemName;
    private String itemCategory;
    private String itemInfo;
    private Long itemPrice;

}
