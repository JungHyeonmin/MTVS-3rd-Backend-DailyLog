package com.ohgiraffers.midnightpractice.model.service;

import com.ohgiraffers.midnightpractice.model.Item;
import com.ohgiraffers.midnightpractice.model.dto.itemdto.FoundItemResponseDTO;
import com.ohgiraffers.midnightpractice.model.dto.itemdto.ItemRegistRequestDTO;
import com.ohgiraffers.midnightpractice.model.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Transactional
    public void registNewItem(ItemRegistRequestDTO itemInfo) {
        Item newItem = new Item(
                itemInfo.getItemName(),
                itemInfo.getItemCategory(),
                itemInfo.getItemInfo(),
                itemInfo.getItemPrice()
        );
    }

    public List<FoundItemResponseDTO> findAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(FoundItemResponseDTO::new)
                .toList();
    }

    public void modifyItemName(Long itemNo, String newItemName) {
        Item foundItem = itemRepository.findById(itemNo)
                .orElseThrow(IllegalAccessError::new);

        foundItem.setItemName(newItemName);
    }

    public void removeItem(Long ItemNo) {
        itemRepository.deleteById(ItemNo);
    }
}
