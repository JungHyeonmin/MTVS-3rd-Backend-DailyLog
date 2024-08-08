package com.ohgiraffers.springdatajpa.section02.querymethod;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface QueryMethodRepository extends JpaRepository<Menu, Integer> {
    List<Menu> findByMenuPriceGreaterThan(int menuPrice);

    List<Menu> findByMenuNameContaining(String menuName);
}
