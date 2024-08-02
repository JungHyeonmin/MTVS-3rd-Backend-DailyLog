package com.example.chap00intro.problem;

import org.junit.jupiter.api.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProblemsOfUsingDirectSQLTests {

    /*
    @BeforeAll // 테스트 메서드가 실행될때 딱 한번만 실행함 // static 으로 선언해야함
    public static void all() {
        System.out.println("all!!!");
    }

    @BeforeEach // 테스트 메서드가 실행할때마다 전에 실행함
    public void setUp() {
        System.out.println("셋업!!!");
    }

    @Test
    void testMethod() {
        System.out.println("테스트 메서드 실행");
    }

    @Test
    void testMethod2() {
        System.out.println("테스트 메서드2 실행");
    }

    @AfterEach // 테스트 메서드가 종료 될때마다 실행함
    public void close() {
        System.out.println("클로즈!!!");
    }

    @AfterAll // 테스트 메서드가 종료 되면 딱 한번만 실행됨 // static 으로 선언해야함
    public static void closeAll() {
        System.out.println("close All!!!");
    }
    */

    private Connection con;

    @BeforeEach
    public void setConnection() throws ClassNotFoundException, SQLException {

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/menudb";
        String user = "ohgiraffers";
        String password = "ohgiraffers";

        Class.forName(driver);

        con = DriverManager.getConnection(url, user, password);
        con.setAutoCommit(false);
    }

    @DisplayName("직접 SQL 을 작성하여 메뉴를 조회할 때 발생하는 문제 확인") // test Results 에 나오는 이름을 변경해준다.
    @Test
    public void testConnection() throws SQLException {
        // Assertions.assertNotNull(con);

        // given
        String query = "SELECT MENU_CODE, MENU_NAME, MENU_PRICE, CATEGORY+CODE, ORDERABLE_STATUS FROM TBL_MENU";

        // when
        Statement stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery(query);

        List<Menu> menus = new ArrayList<>();

        while (rset.next()) {
            Menu menu = new Menu();
            menu.setMenuCode(rset.getInt("MENU_CODE"));
            menu.setMenuCode(rset.getInt("MENU_NAME"));
            menu.setMenuCode(rset.getInt("MENU_PRICE"));
            menu.setMenuCode(rset.getInt("CATEGORY_CODE"));
            menu.setMenuCode(rset.getInt("ORDERABLE_STATUS"));

            menus.add(menu);
        }

        // then
        Assertions.assertNotNull(menus);
        menus.forEach(System.out::println);

        rset.close();
        con.close();
    }

    @DisplayName("직접 SQL 을 작성하여 신규 메뉴를 추가 시 발생하는 문제 확인")
    @Test
    public void testDirectionInsertSQL() throws SQLException {

        // 개발자가 직접 sql 문을 작성하고 값을 입력하는 것이 너무 귀찮아~

        // given
        Menu menu = new Menu();
        menu.setMenuName("멸치알쉐이크");
        menu.setMenuPrice(10000);
        menu.setCategoryCode(9);
        menu.setOrderableStatus("Y");

        String query = "INSERT INTO TBL_MENU(MENU_NAME, MENU_PRICE, MENU_CODE, CATEGORY_CODE, ORDERABLE_STATUS) VALUES(?,?,?,?,?)";

        // when
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, menu.getMenuName());
        pstmt.setDouble(2, menu.getMenuPrice());
        pstmt.setInt(3, menu.getMenuCode());
        pstmt.setInt(4, menu.getCategoryCode());
        pstmt.setString(5, menu.getOrderableStatus());

        int result = pstmt.executeUpdate();

        // then
        Assertions.assertEquals(1, result);
        pstmt.close();

    }

    // 만약 데이터베이스가 아닌 자바 컬렉션에 데이터를 보관하거 가져오는 방식이면? => JPA

    // JPA 의 메서드 방식
    // -> list.add(menu)
    // -> list.get(1)


    // SQL 에 의존적인 불편한 부분을 코드로 확인 - 유지보수에 악영향
    @Test
    public void testChangeSelectColumns() throws SQLException {

        String query = "SELECT MENU_CODE, MENU_NAME FORM TBL_MENU";

        Statement stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery(query);

        List<Menu> menus = new ArrayList<>();

        while (rset.next()) {

            Menu menu = new Menu();
            menu.setMenuCode(rset.getInt("MENU_CODE"));
            menu.setMenuCode(rset.getInt("MENU_NAME"));

            rset.close();
            stmt.close();

            Assertions.assertNotNull(menus);
            menus.forEach(System.out::println);
        }
    }

    @DisplayName("연관된 객체 문제 확인")
    @Test
    public void testAssociatedObject() throws SQLException {

        String query =
                "SELECT A.MENU_CODE, A.MENU_NAME, A.MENU_PRICE, A.CATEGORY_CODE, A.ORDERABLE_STATUS"
                        + " FROM TBL_MENU A " // 띄어쓰기 필수!
                        + "JOIN TBL_CATEGORY B ON(A.CATEGORY_CODE=B.CATEGORY_CODE)";

        Statement stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery(query);

        List<MenuAndCategory> menuAndCategories = new ArrayList<>();

        while (rset.next()) {
            MenuAndCategory menuAndCategory = new MenuAndCategory();
            menuAndCategory.setMenuCode(rset.getInt("MENU_CODE"));
            menuAndCategory.setMenuCode(rset.getInt("MENU_NAME"));
            menuAndCategory.setMenuCode(rset.getInt("MENU_PRICE"));

            Category category = new Category();
            category.setCategoryCode(rset.getInt("CATEGORY_CODE"));
            category.setCategoryName(rset.getString("CATEGORY_NAME"));

            menuAndCategory.setCategory(category);
            menuAndCategory.setOrderalbeStatus(rset.getString("ORDERABLE_STATUS"));

            menuAndCategories.add(menuAndCategory);
        }

        Assertions.assertNotNull(menuAndCategories);
        menuAndCategories.forEach(System.out::println);

        rset.close();
        stmt.close();

    }

    @DisplayName("조회한 두 개의 행을 담은 객체의 동일성 비교 테스트") // 동일성 : 값과 주소가 같다. // 동등성 : 값만 같다.
    @Test
    public void testEquals() throws SQLException {
        String query = "SELECT MENU_CODE, MENU_NAME FROM TBL_MENU WHERE MENU_CODE = 12";

        Statement stmt1 = con.createStatement();
        ResultSet rset1 = stmt1.executeQuery(query);

        Menu menu1 = new Menu();
        while (rset1.next()) {
            menu1 = new Menu();
            menu1.setMenuCode(rset1.getInt("MENU_CODE"));
            menu1.setMenuName(rset1.getString("MENU_NAME"));
        }

        Statement stmt2 = con.createStatement();
        ResultSet rset2 = stmt2.executeQuery(query);

        Menu menu2 = new Menu();
        while (rset2.next()) {
            menu2 = new Menu();
            menu2.setMenuCode(rset2.getInt("MENU_CODE"));
            menu2.setMenuName(rset2.getString("MENU_NAME"));
        }

        Assertions.assertFalse(menu1 == menu2);
        Assertions.assertEquals(menu1.getMenuName(), menu2.getMenuName());

        System.out.println("menu1 = " + menu1);
        System.out.println("menu2 = " + menu2);

        stmt1.close();
        rset1.close();
        stmt2.close();
        rset2.close();

    }

    // Menu menu1 = entityManager.find(Menu.class);
    // Menu menu2 = entityManager.find(Menu.class);
    // menu1 == menu2;  // true



    @AfterEach
    public void closeConnection() throws SQLException {

        con.rollback();
        con.close();
    }


}

