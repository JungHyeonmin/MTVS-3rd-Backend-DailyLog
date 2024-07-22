package com.ohgiraffers.mvcpractice.model.service;

import com.ohgiraffers.mvcpractice.model.dao.GetInventoryMapper;
import com.ohgiraffers.mvcpractice.model.dto.InventoryItemDTO;
import com.ohgiraffers.mvcpractice.model.dto.PlayerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenInventoryService {

    private GetInventoryMapper getInventoryMapper;

    public OpenInventoryService(GetInventoryMapper getInventoryMapper) {
        this.getInventoryMapper = getInventoryMapper;
    }

    public List<InventoryItemDTO> findAllInventory(PlayerDTO loginPlayer) {
        return getInventoryMapper.findAllInventory(loginPlayer.getPlayerNo());
    }
}
