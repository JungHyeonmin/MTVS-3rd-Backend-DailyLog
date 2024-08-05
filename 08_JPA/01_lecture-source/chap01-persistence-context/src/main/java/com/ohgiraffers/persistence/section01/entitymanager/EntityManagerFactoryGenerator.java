package com.ohgiraffers.persistence.section01.entitymanager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// EntityManagerFactoryGenerator 는 EntityManagerFactory 의 싱글톤 인스턴스를 생성하고 제공하는 역할
public class EntityManagerFactoryGenerator {

    // EntityManagerFactory 를 싱글톤 인스턴스로 유지하기 위해 정적 변수로 선언하고 초기화
    // Persistence 에 정의된 persistence unit 인 "ohgiraffers"라는 이름을 기반으로 생성함
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("ohgiraffers");

    public static EntityManagerFactory getInstance() {
        
        // 생성한 싱글톤 인스턴스 반환
        return factory;
    }
}
