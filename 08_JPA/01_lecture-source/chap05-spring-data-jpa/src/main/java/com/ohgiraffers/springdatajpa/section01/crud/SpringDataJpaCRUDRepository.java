package com.ohgiraffers.springdatajpa.section01.crud;

import org.springframework.data.jpa.repository.JpaRepository;

// 대부분의 CRUD 기능은 JpaRepository 인터페이스에 구현되어 있다.
public interface SpringDataJpaCRUDRepository extends JpaRepository<Menu, Integer> {
}
