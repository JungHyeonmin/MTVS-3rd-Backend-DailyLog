package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// sql 문을 만들 때마다 Connection 객체를 만들고 연결해줘야 하는데
// Template 라는 클래스에 getConnection 을 static 메서드로 만들어서 간단하게 호춣해서 사용한다.

public class Template {

    public static Connection getConnection() {

        // db와 연결하는 객체 null 로 초기화
        Connection con = null;
        // property 파일을 읽을 수 있는 객체 생성
        Properties prop = new Properties();

        try {

            // 파일 안의 정보를 읽어들인다.
            prop.load( // FileReader : file 을 매개변수로 받아서 파일의 내용을 읽는다.
                    new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));

            // prop 안에 저장된 정보를 선택해서 문자열에 저장
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");

            /**
             * https://velog.io/@on5949/JAVA-JDBC-Class.forName-%EB%8F%99%EC%9E%91%EA%B3%BC-%EC%82%AC%EC%9A%A9%EC%9D%B4%EC%9C%A0
             *
             * 런타임 동적 로딩을 통해 클래스가 로딩되면 DriverManager 에 Driver 가 등록되는 구조
             *
             * Class.forName()을 쓰는 이유는
             * 1. Driver 의 경우 로드만 하면 되지 객체 생성은 필요 없다.
             * 2. 특정 조건에 따라 Driver 로드한다. 다르게 할 때는 모든 Driver 을 미리 로드할 필요없다.
             */

            // Class.forName() : 모든 클래스를 로딩(컴파일)하지 않고 필요한 시점에 클래스를 로딩하여 사용할 수 있다.
            // -> driver(MySQL) 을 런타임에 동적을 클래스를 로드할 수 있다.
            Class.forName(driver);

            // DriverManager : DriverManager 는 사용할 애플리케이션에 대해 사용 가능한 JDBC(Java Database Connectivity) 드라이버 세트를 관리합니다.
            // getConnection (url, properties) : 왜 두개만? id, password 는 어디로?
            con = DriverManager.getConnection(url, prop);

            /**
             * 10개의 insert 쿼리문이 존재한다고 하자. 이때 3번째 쿼리문이 잘못된 쿼리였다.
             * 만약 이럴때 setAutoCommit을 true로 설정해놓으면 결과는첫번째 두번째 데이터는 insert 되고 나머지는 insert 되지 않는다.
             * 하지만 setAutoCommit를 false로 설정해 놓고 성공시 commit, 실패시 rollback을 지정해놓으면결과는 아무런 데이터도 들어가 않는다는 점이다.
             *
             * = 전부 커밋되거나 전부 커밋되지 않거나
             */

            // insert, delete, update 와 같은 구문을 수행할 때 컴퓨터에서 볼때뿐만 아니라 다른 컴퓨터에서 볼때도 영구적으로 반영하거나 취소하려면
            // commit 과 rollback 을 사용해야 하는데
            // 이런 기능을 프로그래밍 레벨에서 코드로 제어를 하기위해서 자동 커밋을 false 상태로 둔다.
            
            // setAutoCommit() : 연결에 자동 커밋 모드를 사용하려면 true이고, 사용하지 않으려면 false입니다.
            con.setAutoCommit(false);


        } catch (IOException e) {               // fileReader 입출력 예외 처리
            throw new RuntimeException(e);
        } catch (SQLException e) {              // getConnection 예외처리
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {    // forName 예외처리
            throw new RuntimeException(e);
        }
        return con;
    }


    // con, stmt, rset commit, rollback, close 메서드

    public static void commit (Connection con) {
        try {
            con.commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void rollback(Connection con) {
        try {
            con.rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void close(Connection con) {
        try {

            if (con != null && !con.isClosed()) {
                con.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void close(Statement stmt) {
        try {

            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void close(ResultSet rset) {
        try {

            if (rset != null && !rset.isClosed()) {
                rset.close();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
