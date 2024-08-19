package com.ohgiraffers.midnightpractice.model.repository;

import com.ohgiraffers.midnightpractice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
