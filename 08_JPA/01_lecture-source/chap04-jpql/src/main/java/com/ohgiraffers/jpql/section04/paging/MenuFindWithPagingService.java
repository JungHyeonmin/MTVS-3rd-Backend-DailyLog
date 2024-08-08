package com.ohgiraffers.jpql.section04.paging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuFindWithPagingService {


    private MenuFindWithPagingRepository menuRepository;

    @Autowired
    public MenuFindWithPagingService(MenuFindWithPagingRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> findAllMenuWithPaging(int offset, int limit) {

        return menuRepository.findAllMenuWithPaging(PageRequest.of(offset, limit));
    }
}
