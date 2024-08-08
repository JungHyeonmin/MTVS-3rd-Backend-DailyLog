package com.ohgiraffers.jpql.section05.groupfunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupFunctionService {

    private GroupFunctionRepository groupFunctionRepository;

    @Autowired
    public GroupFunctionService(GroupFunctionRepository groupFunctionRepository) {
        this.groupFunctionRepository = groupFunctionRepository;
    }

    public long countMenuByCategoryCode(int categoryCode) {

        return groupFunctionRepository.countMenuByCategoryCode(categoryCode);
    }

    public Long sumMenuPriceByCategoryCode(int categoryCode) {

        return groupFunctionRepository.sumMenuPriceByCategoryCode(categoryCode);
    }

    public List<Object[]> sumMenuPriceGroupByCategoryCode(long minPrice) {

        return groupFunctionRepository.sumMenuPriceGroupByCategoryCode(minPrice);
    }
}
