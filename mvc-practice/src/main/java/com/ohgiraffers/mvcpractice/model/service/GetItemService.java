package com.ohgiraffers.mvcpractice.model.service;

import com.ohgiraffers.mvcpractice.model.dao.GetItemMapper;
import com.ohgiraffers.mvcpractice.model.dto.ItemDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetItemService {

    private GetItemMapper getItemMapper;

    public GetItemService(GetItemMapper getItemMapper) {
        this.getItemMapper = getItemMapper;
    }

    public List<ItemDTO> getItem() {
        return getItemMapper.findAllItem();
    }

    @Transactional
    public void addInventory(int playerNo, int itemNo) {

        Map<String, Integer> item = new HashMap<>();
        item.put("playerNo", playerNo);
        item.put("itemNo", itemNo);
        getItemMapper.insertUserInventory(item);

    }
}
