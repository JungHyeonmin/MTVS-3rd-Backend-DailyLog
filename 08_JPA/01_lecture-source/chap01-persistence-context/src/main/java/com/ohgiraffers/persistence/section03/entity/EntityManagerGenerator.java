package com.ohgiraffers.persistence.section03.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerGenerator {


    private static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("ohgiraffers");

    private EntityManagerGenerator() {
    }

    public static EntityManager getManagerInstance() {
        return entityManagerFactory.createEntityManager();
    }
}
