package com.ohgiraffers.jpql.section05.groupfunction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupFunctionRepository extends JpaRepository<Menu, Integer> {

    @Query("SELECT COUNT(*) FROM Section05Menu m WHERE m.categoryCode=:categoryCode")
    long countMenuByCategoryCode(int categoryCode);

    @Query("SELECT SUM(m.menuPrice) FROM Section05Menu m WHERE m.categoryCode = :categoryCode")
    Long sumMenuPriceByCategoryCode(int categoryCode);

    @Query("SELECT m.categoryCode, SUM(m.menuPrice) " +
            "FROM Section05Menu m " +
            "GROUP BY m.categoryCode " +
            "HAVING SUM(m.menuPrice)>= :minPrice")
    List<Object[]> sumMenuPriceGroupByCategoryCode(long minPrice);
}
