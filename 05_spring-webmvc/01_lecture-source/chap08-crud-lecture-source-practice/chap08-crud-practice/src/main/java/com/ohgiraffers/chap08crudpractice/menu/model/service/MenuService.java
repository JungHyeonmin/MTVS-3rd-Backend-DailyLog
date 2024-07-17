package com.ohgiraffers.chap08crudpractice.menu.model.service;

import com.ohgiraffers.chap08crudpractice.menu.model.dao.MenuMapper;
import com.ohgiraffers.chap08crudpractice.menu.model.dto.CategoryDTO;
import com.ohgiraffers.chap08crudpractice.menu.model.dto.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// @Service : 비지니스 로직을 처리하는 서비스 클래스, 해당 클래스를 스프링의 bean 으로 등록하는 역할을 한다.
@Service
public class MenuService {

    // 인터페이스 타입 필드 선언 - 서비스가 컴포넌트 기능도 있는데 객체를 생성해서
    // Mybatis에서 인터페이스를 구체적으로 구현할 수 있는 구현체를 제공

    // 인터페이스의 구현체를 만들어서 xml 쿼리문의 결과를 받아와서 사용한다. (DI) == ServiceImpl
    /**
     * 주요 용도 및 장점
     * <p>
     * 구현체의 교체 용이 :
     * 인터페이스를 사용하면 해당 인터페이스를 구현하는 다양한 구현체를 쉽게 교체할 수 있습니다.
     * 예를 들어, 테스트 환경에서는 목(Mock) 구현체를 사용할 수 있고, 실제 환경에서는 실제 구현체를 사용할 수 있습니다.
     * <p>
     * 코드의 유연성과 확장성 증가 :
     * 인터페이스를 사용하면 코드가 특정 구현체에 의존하지 않기 때문에 더 유연하고 확장 가능하게 됩니다. 새로운 구현체를 추가해도 기존 코드를 수정할 필요가 없습니다.
     * <p>
     * 느슨한 결합 :
     * 인터페이스를 통해 클래스 간의 결합도를 낮출 수 있습니다. 클래스가 서로 직접적으로 의존하지 않고 인터페이스에 의존하게 되어 변경에 더 유연해집니다.
     * <p>
     * 의존성 주입 (Dependency Injection) 용이 :
     * 스프링 프레임워크와 같은 DI 프레임워크에서 인터페이스를 사용하면 구현체를 주입받기 쉽습니다. 이를 통해 런타임에 어떤 구현체를 사용할지 유연하게 결정할 수 있습니다.
     */

    // Mapper 인터페이스의 메서드를 사용하기 위해서 필드에 선언하고 생성자를 이용해서 메서드를 가지고 있는 객체를 생성한다.
    private final MenuMapper menuMapper;

    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }


    // Mapper 객체로 메서드를 호출하여 각 SQL 문을 실행한 결과를 받아온다.


    public List<MenuDTO> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    public List<CategoryDTO> findAllCategory() {
        return menuMapper.findAllCategory();
    }

    @Transactional
    public void registNewMenu(MenuDTO newMenu) {
        menuMapper.registNewMenu(newMenu);
    }
}
