package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {

        Connection con = null;

        try {
            // 클래스 동적 로딩, 사용할 드라이버 등록
            Class.forName("com.mysql.cj.jdbc.Driver"); // db를 바꾸면 ()안에만 바꾸면 된다.

            //  getConnection - add catch 옵션 선택
                       con = DriverManager.getConnection("jdbc:mysql://localhost/employee", "ohgiraffers", "ohgiraffers");

            System.out.println("con = " + con);

            // 예외 처리 잘 찾아보기
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {  // 통로를 열지 않고 닫으려고 하면 NullPointException 이 발생한다. 그래서 if 문으로 방지한다.
                try { // NullPointException :
                    con.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
