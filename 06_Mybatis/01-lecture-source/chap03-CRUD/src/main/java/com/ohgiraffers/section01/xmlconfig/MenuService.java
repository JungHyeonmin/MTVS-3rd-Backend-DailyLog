package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class MenuService { 
    
    // 메모리 낭비 방지를 위해서 필드에  선언
    private final MenuDAO menuDAO;

    public MenuService() {
        menuDAO = new MenuDAO();
    }

    public List<MenuDTO> findAllMenus() {

        SqlSession sqlSession = getSqlSession();

        List<MenuDTO> menuList = menuDAO.findAllMenus(sqlSession);

        sqlSession.close();

        return menuList;
    }
}