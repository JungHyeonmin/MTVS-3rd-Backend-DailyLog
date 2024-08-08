package com.ohgiraffers.jpql.section06.join;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface JoinRepository extends JpaRepository<Menu, Integer> {

    @Query("SELECT m FROM Section06Menu  m JOIN m.category c")
    List<Menu> findAllMenuUsingInnerJoin();

    // FETCH JOIN
    @Query("SELECT m FROM Section06Menu  m JOIN FETCH m.category c") // JOIN 에 FETCH 추가!
    List<Menu> findAllMenusUsingFetchJoin();

    // COLLECTION JOIN - DISTINCT : 중복 방지 키워드
    @Query("SELECT DISTINCT c FROM Section06Category c LEFT JOIN c.menuList m")
    List<Category> findAllMenusInCategory();

}
