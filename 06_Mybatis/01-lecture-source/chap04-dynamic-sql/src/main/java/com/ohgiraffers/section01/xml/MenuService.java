package com.ohgiraffers.section01.xml;

import com.ohgiraffers.common.MenuDTO;
import com.ohgiraffers.common.SearchCriteria;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.common.Template.getSqlSession;

public class MenuService {

    public void findMenuByPrice(int price) {

        SqlSession sqlSession = getSqlSession();
        DynamicSqlMapper mapper = sqlSession.getMapper(DynamicSqlMapper.class);

        Map<String, Integer> map = new HashMap<>();
        map.put("price", price);

        List<MenuDTO> menuList = mapper.findMenuByPrice(map);

        sqlSession.close();

        if(menuList != null) {
            if(menuList.size() == 0) {
                System.out.println("검색된 메뉴가 없습니다.");
            } else {
                menuList.forEach(System.out::println);
            }
        } else {
            System.out.println("메뉴 조회를 실패하셨습니다!");
        }
    }

    public void searchMenu(SearchCriteria searchCriteria) {


    }
}