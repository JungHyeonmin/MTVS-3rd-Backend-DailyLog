package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section01.xmlconfig.Template.getSqlSession;

public class MenuService {

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

    public MenuDTO findMenuByMenuCode(int menuCode) {

        SqlSession sqlSession = getSqlSession();

        MenuDTO menu = menuDAO.findMenuByMenuCode(sqlSession, menuCode);

        sqlSession.close();

        return menu;
    }

    public boolean registMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.registMenu(sqlSession, menu);

        // 트랜잭션 제어가 중요하다.
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean modifyMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.modifyMenu(sqlSession, menu);

        // 트랜잭션
        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }

    public boolean removeMenu(int menuCode) {

        // == Connection
        SqlSession sqlSession = getSqlSession();

        int result = menuDAO.removeMenu(sqlSession, menuCode);

        if (result > 0) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0;
    }
}