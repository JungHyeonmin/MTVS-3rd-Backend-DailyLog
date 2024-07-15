package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {


    public List<MenuDTO> findAllMenus(SqlSession sqlSession) {

        return sqlSession.selectList("MenuMapper.findAllMenus");
    }
}