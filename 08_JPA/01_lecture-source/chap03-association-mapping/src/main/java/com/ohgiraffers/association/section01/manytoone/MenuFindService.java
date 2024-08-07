package com.ohgiraffers.association.section01.manytoone;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional // 한메서드 안에 작성한 내용을 하나의 트랜젝션에 묶는다.
public class MenuFindService {

    private MenuRepository menuRepository;

    @Autowired
    public MenuFindService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    // 지연 로딩 : 필요할 때마다 새로운 Session 으로 새로운 테이블을 가져온다.
    public Menu findMenuByMenuCode(int menuMenu){
        return menuRepository.findMenuByMenuCode(menuMenu);
    };
}
