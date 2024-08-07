package com.ohgiraffers.jpql.section02.parameter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParameterBindingMenuRepository extends JpaRepository<Menu, Integer> {

    @Query("SELECT m FROM Section02Menu m WHERE m.menuCode = :menuCode")
    Menu bindParameterWithName(@Param("menuCode") int menuCode);

    @Query("SELECT m FROM Section02Menu m WHERE m.menuCode =?1")
    Menu bindParameterWithOrder(int menuCode);
}