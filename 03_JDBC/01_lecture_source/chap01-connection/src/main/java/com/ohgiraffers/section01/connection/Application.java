package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {

        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/employee";
        String user = "ohgiraffers";
        String password = "ohgiraffers";

        // null 로 초기화 한 이유 : scope 때문이다. try 블럭 내에서 선언 시에 finally 블럭에서 close()로 닫을 수 있도록 밖에서 선언과 초기화를 했다.
        Connection con = null;

        try {
            // 클래스 동적 로딩, 사용할 드라이버 등록
            Class.forName(driver); // db를 바꾸면 ()안에만 바꾸면 된다.

            // getConnection ("url", "user", "password") - add catch 옵션 선택
            con = DriverManager.getConnection(url, user, password);

            System.out.println("con = " + con);

            // 예외 처리 잘 찾아보기
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {  // 통로를 열지 않고 닫으려고 하면 NullPointException 이 발생한다. 그래서 if 문으로 방지한다.
                try { // NullPointException : 참조형(reference) 변수가 null 을 저장하고 null 값으로 이동하려고 할때 발생한다.
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
