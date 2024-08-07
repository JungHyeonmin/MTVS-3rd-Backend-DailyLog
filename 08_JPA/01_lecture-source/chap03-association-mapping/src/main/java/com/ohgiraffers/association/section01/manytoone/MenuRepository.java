package com.ohgiraffers.association.section01.manytoone;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class MenuRepository {

    @PersistenceContext
    private EntityManager manager;

    public Menu findMenuByMenuCode(int menuCode) {

        return manager.find(Menu.class, menuCode);
    }
}
