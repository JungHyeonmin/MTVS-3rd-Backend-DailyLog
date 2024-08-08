package com.ohgiraffers.jpql.section04.paging;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuFindWithPagingRepository extends JpaRepository<Menu, Integer> {

    @Query("SELECT m FROM Section04Menu m Order BY m.menuCode DESC")
    List<Menu> findAllMenuWithPaging(Pageable pageable); // 페이지 정보를 담는 레포지토리

}
