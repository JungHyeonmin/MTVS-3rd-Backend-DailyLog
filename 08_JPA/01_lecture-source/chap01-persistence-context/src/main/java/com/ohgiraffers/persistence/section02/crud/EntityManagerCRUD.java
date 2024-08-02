package com.ohgiraffers.persistence.section02.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EntityManagerCRUD {

    private EntityManager manager;

    public Menu findMenuByMenuCode(int menuCode) {

        manager = EntityManagerGenerator.getManagerInstance();

        return manager.find(Menu.class, menuCode);
    }

    public EntityManager getManagerInstance() {

        return manager;
    }

    public Long saveAndReturnAllCount(String menuName, int menuPrice, int categoryCode, String orderableStatus) {

        manager = EntityManagerGenerator.getManagerInstance();

        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.persist(new Menu(menuName, menuPrice, categoryCode, orderableStatus));
        manager.flush();

        return getCount(manager);
    }

    private Long getCount(EntityManager manager) {

        return manager.createQuery("select count(*) from Section02Menu", Long.class).getSingleResult();
    }

    public Menu modifyMenuName(int menuCode, String menuName) {

        Menu menu = findMenuByMenuCode(menuCode);
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        menu.setMenuName(menuName);
        manager.flush();

        return menu;
    }

    public Long removeAndReturnAllCount(int menuCode) {

        Menu menu = findMenuByMenuCode(menuCode);
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();
        manager.remove(menu);
        manager.flush();

        return getCount(manager);
    }
}
