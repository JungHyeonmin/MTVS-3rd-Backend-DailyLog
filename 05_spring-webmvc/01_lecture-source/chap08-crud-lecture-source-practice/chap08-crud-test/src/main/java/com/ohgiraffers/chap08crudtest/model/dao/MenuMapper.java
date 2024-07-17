package com.ohgiraffers.chap08crudtest.model.dao;

import com.ohgiraffers.chap08crudtest.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {

    // 메뉴 추가 메서드
    void insertMenu(MenuDTO menu);

    // 전체 메뉴 추가 메서드
    List<MenuDTO> findAllMenu();
}
