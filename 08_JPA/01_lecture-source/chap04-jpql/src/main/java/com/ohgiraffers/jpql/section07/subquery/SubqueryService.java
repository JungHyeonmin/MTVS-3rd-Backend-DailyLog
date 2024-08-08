package com.ohgiraffers.jpql.section07.subquery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubqueryService {

    private SubqueryRepository subqueryRepository;

    @Autowired
    public SubqueryService(SubqueryRepository subqueryRepository) {
        this.subqueryRepository = subqueryRepository;
    }

    public List<Menu> findAllMenusByCategoryNameUsingSubQuery(String categoryName) {

        return subqueryRepository.findAllMenusByCategoryNameUsingSubQuery(categoryName);
    }
}
