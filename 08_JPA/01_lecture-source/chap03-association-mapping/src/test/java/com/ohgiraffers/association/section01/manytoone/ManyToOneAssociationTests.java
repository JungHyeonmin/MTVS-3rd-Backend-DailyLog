package com.ohgiraffers.association.section01.manytoone;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManyToOneAssociationTests {

    /**
     * Association Mapping 은 Entity 간의 관계를 매핑하는 것을 의미한다.
     * 이를 통해 객체를 이용해 데이터베이스 테이브 간의 관계를 매핑할 수 있다.
     * <p>
     * - 다중성에 의한 분류
     * 연관관계가 있는 객체 관계에서 실제로 연관을 가지는 객체의 수에 따라 분류
     * N:1(ManyToOne), 1:N(OneToMany), 1:1(OneToOne), N:N(ManyToMany)
     * <p>
     * - 방향에 따른 분류
     * 테이블의 연관 관계는 외래키를 이용하여 양방향 연관관계의 특징을 가진다.
     * 참조에 의한 객체의 연관 관계는 단방향이다.
     * 단방향 연관관계, 양방향 연관관계
     * 객체간의 연곽관계를 양방향으로 만들고 싶은 경우 반대쪽에서도 필드를 추가해서 참조를 보관하면 된다.
     * 하지만 엄밀하게 이는 양방향 관계가 아닌 단방향 관계 2개로 볼 수 있다.
     * <p>
     * ManyToOne : 다수의 엔티티가 하나의 엔티티를 참조하는 상황에서 사용한다.
     */

    @Autowired
    private MenuFindService menuFindService;

    @DisplayName("메뉴 코드로 조회하여 메뉴 이름이 일치하는지 테스트")
    @ParameterizedTest
    @CsvSource({"1, 커피", "2, 기타"})
    @Transactional
        // 라이프 사이클이 같은 두개의 영속성을 묶을 때만 사용한다.
        // 지연 로딩의 경우 트랜젝션이 종료되면 session 이 close 되면서 준영속 상태가 된다.
        // 엔티티 매니저가 관리하지 않는 객체가 되는 것이기 때문에 세션이 종료되었다는 에러가 발생한다.
        // 지연 로딩을 이용하는 경우 동일한 트랜젝션 내에서 사용해야 한다.
    void testSelectMenuCompareToMenuName(int menuCode, String menuName) {

        // session close(transaction 마감) 하면 준영속성으로 변한다.
        Menu foundMenu = menuFindService.findMenuByMenuCode(menuCode);

        Assertions.assertEquals(menuName, foundMenu.getCategory().getCategoryName());
    }

}
