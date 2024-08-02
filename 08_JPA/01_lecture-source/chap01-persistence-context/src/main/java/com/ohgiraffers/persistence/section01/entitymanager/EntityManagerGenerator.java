package com.ohgiraffers.persistence.section01.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class EntityManagerGenerator {

    public static EntityManager getInstance() {

        EntityManagerFactory factory = EntityManagerFactoryGenerator.getInstance();
        EntityManager manager = factory.createEntityManager();

        return manager;
    }
}
