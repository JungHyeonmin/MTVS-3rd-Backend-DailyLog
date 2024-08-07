package com.ohgiraffers.jpql.sectioin01.simple;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MenuRepository {

    @PersistenceContext
    private EntityManager manager;


    public String findMenuNameByMenuCode(int menuCode) {
        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = :menuCode";
        TypedQuery<String> query = manager.createQuery(jpql, String.class);
        query.setParameter("menuCode", menuCode);

        return query.getSingleResult();

    }

    public Object findObjectByMenuCode(int menuCode) {

        String jpql = "SELECT m.menuName FROM Section01Menu as m WHERE m.menuCode = :menuCode";
        Query query = manager.createQuery(jpql);
        query.setParameter("menuCode", menuCode);

        return query.getSingleResult();
    }

    public List<Menu> findAllMenusWithTypedQuery() {

        String jpql = "SELECT m FROM Section01Menu as m";
        TypedQuery<Menu> query = manager.createQuery(jpql, Menu.class);

        return query.getResultList();
    }

    public List<Menu> findAllMenusWithQuery() {

        String jpql = "SELECT m FROM Section01Menu as m";
        Query query = manager.createQuery(jpql);

        return query.getResultList();
    }


    public List<Integer> findAllCategoryCodeInMenu() {

        String jpql = "SELECT DISTINCT m.categoryCode FROM Section01Menu as m";
        TypedQuery<Integer> query = manager.createQuery(jpql, Integer.class);

        return query.getResultList();
    }

    public List<Menu> findMenusInCategoryCodes(List<Integer> categoryCodes) {

        StringBuilder jpql = new StringBuilder();
        jpql.append("SELECT m FROM Section01Menu m WHERE m.categoryCode in (");

        int categoryCodeSize = categoryCodes.size(); // size 는 호출할 때마다 계산하기 때문에 변수로 따로 저장해서 사용한다.
        for (int i = 0; i < categoryCodeSize; i++) {
            jpql.append(categoryCodes.get(i));
            if (i != categoryCodeSize - 1) {
                jpql.append(",");
            }
        }

        TypedQuery<Menu> query = manager.createQuery(jpql.toString(), Menu.class);

        return query.getResultList();
    }

    public List<Menu> searchMenusBySearchValue(String searchValue) {
        String jpql = "SELECT m FROM Section01Menu m WHERE m.menuName LIKE CONCAT('%', :searchValue, '%')";

        return manager.createQuery(jpql, Menu.class)
                .setParameter("searchValue", searchValue)
                .getResultList();
    }
}
