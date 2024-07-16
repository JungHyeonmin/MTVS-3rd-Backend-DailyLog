package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {


    public List<MenuDTO> findAllMenus(SqlSession sqlSession) {

        // selectList() : 여러개 행 조회
        return sqlSession.selectList("MenuMapper.findAllMenus");
    }

    public MenuDTO findMenuByMenuCode(SqlSession sqlSession, int menuCode) {

        // selectOne : 1개 행 조회 // menuCode 위치 : SQL 로 한개의 값만 보낼 수 있다.
        return sqlSession.selectOne("MenuMapper.findMenuByMenuCode", menuCode);
    }

    public int registMenu(SqlSession sqlSession, MenuDTO menu) {

        // 세 가지의 정보를 가지고 있는 MenuDTO 객체로 전달
        return sqlSession.insert("MenuMapper.registMenu", menu);
    }
}