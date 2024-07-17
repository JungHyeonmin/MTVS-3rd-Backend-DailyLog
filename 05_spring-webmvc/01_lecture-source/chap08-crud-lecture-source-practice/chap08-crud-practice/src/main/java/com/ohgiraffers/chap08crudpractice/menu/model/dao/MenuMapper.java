package com.ohgiraffers.chap08crudpractice.menu.model.dao;

import com.ohgiraffers.chap08crudpractice.menu.model.dto.CategoryDTO;
import com.ohgiraffers.chap08crudpractice.menu.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 인터페이스와 xml 을 자동으로 연결해서 사용할 수 있다!!!!
 * 쿼리는 xml, 호출은 Mapper 에 작성한다.
 * xml 과 interface 의 이름이 같아야한다.
 * resources 와 main 패키지가 같아야한다.
 * namespace 을 풀네임을 작성해야한다.
 * <p>
 * xml의 쿼리문과 메서드의 이름으로 연결되어 있고 DB의 작업을 실행한 결과를 가져온다.
 */
@Mapper
public interface MenuMapper {

    // 모든 메뉴를 출력하는 메서드
    List<MenuDTO> findAllMenu();

    // 모든 카테고리를 출력하는 메서드
    List<CategoryDTO> findAllCategory();

    // 새로운 메뉴를 추가하는 메서드
    void registNewMenu(MenuDTO newMenu);
}
