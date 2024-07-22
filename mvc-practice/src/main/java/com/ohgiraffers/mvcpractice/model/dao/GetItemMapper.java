package com.ohgiraffers.mvcpractice.model.dao;

import com.ohgiraffers.mvcpractice.model.dto.ItemDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GetItemMapper {

    List<ItemDTO> findAllItem();

    void insertUserInventory(Map<String, Integer> map);
}
