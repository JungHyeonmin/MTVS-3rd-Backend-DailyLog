package com.ohgiraffers.mvcpractice.model.dao;

import com.ohgiraffers.mvcpractice.model.dto.InventoryItemDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GetInventoryMapper {

    List<InventoryItemDTO> findAllInventory(int playerNo);
}
