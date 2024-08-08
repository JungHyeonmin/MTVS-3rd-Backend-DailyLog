package com.ohgiraffers.springdatajpa.section01.crud;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpringDataJpaCRUDService {

    private SpringDataJpaCRUDRepository crudRepository;

    @Autowired
    public SpringDataJpaCRUDService(SpringDataJpaCRUDRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public List<FoundMenuResponseDTO> findAllMenus() {
        // findAll 로 리턴을 받는것은
        // return crudRepository.findAll()
        //        .stream()
        //        .map(menu -> new FoundMenuResponseDTO(menu))
        //        .collect(Collectors.toList());


        return crudRepository.findAll()
                .stream()
                .map(FoundMenuResponseDTO::new)
                .toList();
    }

    public FoundMenuResponseDTO findMenuByMenuCode(int menuCode) {

        // findById 로 값을 꺼낼때 값이 없다면 null 을 발생시킨다.
        return new FoundMenuResponseDTO(
                crudRepository.findById(menuCode)
                        .orElseThrow(IllegalAccessError::new));
    }

    // 입력(등록)은 void 로 만든다.
    @Transactional
    public void registNewMenu(MenuRegistRequestDTO menuInfo) {
        Menu newMenu = new Menu(
                menuInfo.getMenuName(),
                menuInfo.getMenuPrice(),
                menuInfo.getCategoryCode(),
                menuInfo.getOrderableStatus()
        );

        crudRepository.save(newMenu); // newMenu 등록
    }

    @Transactional // 커밋과 롤백, flush 기능
    public void modifyMenuName(int menuCode, String menuName) {

        Menu foundMenu = crudRepository.findById(menuCode).orElseThrow(IllegalAccessError::new);
        foundMenu.setMenuName(menuName);
    }

    public void removeMenu(int menuCode) {

        // delete(Menu entity)
        crudRepository.deleteById(menuCode);
    }
}
