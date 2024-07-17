package com.ohgiraffers.chap08crudtest.model.service;

import com.ohgiraffers.chap08crudtest.model.dao.MenuMapper;
import com.ohgiraffers.chap08crudtest.model.dto.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MenuService {

    private MenuMapper menuMapper;

    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    @Transactional
    public void registMenu(MenuDTO menu) {
        menuMapper.insertMenu(menu);
    }

    public List<MenuDTO> getAllList() {

        return menuMapper.findAllMenu();
    }
}
