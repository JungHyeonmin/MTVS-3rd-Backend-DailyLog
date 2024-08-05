package com.ohgiraffers.persistence.section03.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.stream.Stream;

public class EntityLifecycleTests {
    /**
     * 엔티티의 생명주기
     * <p>
     * 비영속 (new/transient) : 영속성 컨텍스트와 전혀 관계가 없는 상태
     * 영속 (managed) : 영속성 컨텍스트에 저장된 상태
     * 준영속 (detached) : 영속성 컨텍스트에 저장되었다가 분리된 상태 - 다시 영속성이 될 수 있다.
     * 삭제 (removed) : 삭제된 상태
     * <p>
     * 영속성 컨텍스트?
     * 엔티티 매니저가 엔티티 객체를 젖아하는 공간으로 엔티티 객체를 보관하고 관리한다.
     * (엔티티 매니저가 생성괼 때 하나의 영속성 컨텍스트가 만들어진다.)
     * <p>
     * 영속화 : Entity Manager(persistence) 가 영속성 컨텍스트 에 저장하는 것을 말한다.
     * 영속화 컨텍스트 : Entity Manager(persistence) 영속화 한 값을 보관하는 곳
     */

    private EntityLifecycle lifecycle;

    @BeforeEach
    void setUp() {
        lifecycle = new EntityLifecycle();
    }

    @DisplayName("비영속성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    void testTransient(int menuCode) {

        // 요청할 때마다 EntityManager 가 새롭게 생성되도록 설정함
        Menu foundMenu = lifecycle.findMenuByMenuCode(menuCode);

        Menu newMenu = new Menu(
                menuCode,
                foundMenu.getMenuName(),
                foundMenu.getMenuPrice(),
                foundMenu.getCategoryCode(),
                foundMenu.getOrderalbeStatus()
        );

        Assertions.assertNotEquals(newMenu, foundMenu);
    }

    @DisplayName("다른 엔티티 매니저가 관리하는 엔티티의 영속성 조회 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testManagedOtherEntityManager(int menuCode) {

        Menu menu1 = lifecycle.findMenuByMenuCode(menuCode);
        Menu menu2 = lifecycle.findMenuByMenuCode(menuCode);

        Assertions.assertNotEquals(menu1, menu2);
    }

    @DisplayName("같은 엔티티 매니저가 관리하는 엔티티의 영속성 조회 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testManagedSameEntityManager(int menuCode) {

        EntityManager manager = EntityManagerGenerator.getManagerInstance();

        Menu menu1 = manager.find(Menu.class, menuCode);
        Menu menu2 = manager.find(Menu.class, menuCode);

        Assertions.assertEquals(menu1, menu2);
    }

    private static Stream<Arguments> newMenu() {
        return Stream.of(
                Arguments.of("새로운 메뉴", 5000, 4, "Y")
        );
    }


    @DisplayName("엔티티 영속성 추가 테스트")
    @ParameterizedTest
    @MethodSource("newMenu")
    void testManagedNewEntity(String menuName, int menuPrice, int categoryCode, String orderalbeStatus) {

        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        EntityTransaction transaction = manager.getTransaction();

        Menu menu = new Menu(menuName, menuPrice, categoryCode, orderalbeStatus);

        transaction.begin();
        manager.persist(menu);
        manager.flush();

        // 새로 만든 manager 영속화 // 컨텍스트에 저장만 하고 db에 적용하지 않은 상태
        // manager.persist(menu);

        // true 인지 검증하고 true 면 반환 // 컨텍스트에 갖고있니? 갖고있어 라고 답이 온다.
        Assertions.assertTrue(manager.contains(menu));
        transaction.rollback();
    }

    @DisplayName("엔티티 속성 변경 테스트")
    @ParameterizedTest
    @CsvSource({"1,메론죽", "2,김치딸기죽"})
    void testManagedEntityModify(int menuCode, String menuName) {

        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        Menu foundMenu = manager.find(Menu.class, menuCode);
        EntityTransaction transaction = manager.getTransaction();

        foundMenu.setMenuName(menuName);

        Menu expectedMenu = manager.find(Menu.class, menuCode); // expectedMenu 는 변경된 값을 가지고 있다.
        Assertions.assertEquals(expectedMenu.getMenuName(), foundMenu.getMenuName());

        transaction.rollback();
    }

    @DisplayName("준영속성 detach 테스트") // 엔티티 매니저가 관리하지 않는 객체로 변환 영속성 -> 준영속성
    @ParameterizedTest
    @CsvSource({"11,1000", "12, 1000"})
    void testDetachEntity(int menuCode, int menuPrice) {

        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        EntityTransaction transaction = manager.getTransaction();

        Menu foundMenu = manager.find(Menu.class, menuCode);

        transaction.begin();
        manager.detach(foundMenu); // 영속화 되어있는 Menu 를 준영속성으로 변환하는 메서드
        foundMenu.setMenuPrice(menuPrice);
        manager.flush();

        Assertions.assertNotEquals(foundMenu.getMenuPrice(), manager.find(Menu.class, menuCode).getMenuPrice());
        transaction.rollback();

    }

    @DisplayName("준영속성 detach 후 다시 영속화 테스트")
    @ParameterizedTest(name = "[{index}] 준영속화 된 {0}번 메뉴를 {1}원으로 변경하고 다시 영속화 되는지 확인")
    @CsvSource({"11, 1000", "12, 1000"})
    void testDetachAndPersist(int menuCode, int menuPrice) {

        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        EntityTransaction transaction = manager.getTransaction();
        Menu foundMenu = manager.find(Menu.class, menuCode);

        transaction.begin();
        manager.detach(foundMenu); // 준영속성 상태로 변환
        foundMenu.setMenuPrice(menuPrice);

        manager.merge(foundMenu); // 영속성 상태로 변환
        manager.flush();

        Assertions.assertEquals(
                foundMenu.getMenuPrice(), manager.find(Menu.class, menuCode).getMenuPrice()
        );
        transaction.rollback();
    }

    @DisplayName("준영속성 clear 테스트") // clear : 컨텍스트가 관리하고 있는 영속성 객체를 준영속성 객체로 바꾼는 메서드
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testClearPersistence(int menuCode) {

        EntityManager manager = EntityManagerGenerator.getManagerInstance();

        Menu foundMenu = manager.find(Menu.class, menuCode);
        manager.clear(); // 영속성 컨텍스트 내부에 있는 모든 엔티티는 준영속성 상태가 된다.

        Menu expectedMenu = manager.find(Menu.class, menuCode); // 조회하면 새롭게 조회한 객체를 가지고 새로운 영속성을 만든다.
        Assertions.assertNotEquals(expectedMenu, foundMenu);
    }

    @DisplayName("준영속성 close 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void testClosePersistenceContext(int menuCode) {

        // close 는 영속성 컨텍스트를 종료시킨다. -> 나를 관리하는 컨텍스트가 사라졌다. -> 준영속성 상태
        // 종료시킨 이후 다시 영속성 컨텍스트를 사용하려 하면 IllegalStateException 이 발생하게 된다.

        EntityManager manager = EntityManagerGenerator.getManagerInstance();

        Menu foundMenu = manager.find(Menu.class, menuCode);
        manager.close();
        // 첫번째인자는 내가 기대하는 exception 타입, 두번째 인자는 내가 람다 형태로 실행할 코드를 입력

        // Assertions : 소프트웨어 개발에서 코드의 특정 조건이나 상태를 확인하고 검증하는 데 사용되는 프로그래밍 기술
        Assertions.assertThrows(IllegalAccessError.class, // 첫번째인자는 내가 기대하는 exception 타입, 두번째 인자는 내가 람다 형태로 실행할 코드를 입력
                () -> manager.find(Menu.class, menuCode)
        );
    }

    @DisplayName("영속성 엔티티 삭제 remove 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void testRemoveEntity(int menuCode) {

        EntityManager manager = EntityManagerGenerator.getManagerInstance();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();

        Menu foundMenu = manager.find(Menu.class, menuCode);
        manager.remove(foundMenu);

        manager.flush();

        Assertions.assertFalse(manager.contains(foundMenu)); // 존재하지 않으면 contains
        transaction.rollback();
    }
}
