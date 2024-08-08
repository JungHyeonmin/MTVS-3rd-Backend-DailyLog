package com.ohgiraffers.springdatajpa.section02.querymethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryMethodService {

    private QueryMethodRepository queryMethodRepository;

    @Autowired
    public QueryMethodService(QueryMethodRepository queryMethodRepository) {
        this.queryMethodRepository = queryMethodRepository;
    }


    public List<FoundMenuResponseDTO> findByMenuPriceGreaterThan(int menuPrice) {

        //
        // 오타가 있으면 sql 문을 잘 못만들어 준다.
        return queryMethodRepository.findByMenuPriceGreaterThan(menuPrice)
                .stream()
                .map(FoundMenuResponseDTO::new)
                .toList();
    }

    public List<FoundMenuResponseDTO> findByMenuNameContaining(String menuName) {
        return queryMethodRepository.findByMenuNameContaining(menuName)
                .stream()
                .map(FoundMenuResponseDTO::new)
                .toList();
    }
}
