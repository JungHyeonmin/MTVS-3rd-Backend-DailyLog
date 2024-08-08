package com.ohgiraffers.jpql.section07.subquery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubqueryRepository extends JpaRepository<Menu, Integer> {

    @Query("SELECT m FROM Section07Menu m WHERE m.categoryCode = (" +
            "SELECT c.categoryCode " +
            "FROM Section07Category c " +
            "WHERE c.categoryName = :categoryName" +
            ")")
    List<Menu> findAllMenusByCategoryNameUsingSubQuery(String categoryName);
}