package com.ohgiraffers.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
        // Connection 클래스 : db와 연결할 수 있게 해주는 클래스
        Connection con = null;

        try {
            // 클래스 동적 로딩, 사용할 드라이버 등록
            // Class.forName() : Class 클래스는 클래스의 메타 정보를 가지고 있다.
            // forName() : 메서드에 풀 클래스명을 작성하면 해당 클래스를 메모리에 올려 사용할 준비를 하도록 하는 것으로, 동적 로딩을 이용하여 DB driver 를 로딩한다.
            // -> 주의사항 1. 반드시 예외처리를 해야한다. 2. 직접 instance 가 불가능하고 DriverManager 클래스의 getConnection()메서드를 이용하여 인스턴스를 생성한다.
            Class.forName("com.mysql.cj.jdbc.Driver"); // db를 바꾸면 ()안에만 바꾸면 된다.


            // DriverManager 주의사항 2번째! -> 직접 instance 가 불가능하고 DriverManager 클래스의 getConnection()메서드를 이용하여 인스턴스를 생성한다.
            //  getConnection() : 지정된 사용자 이름 및 암호를 사용하여 SQLServerDataSource 객체가 나타내는 데이터 원본과의 연결을 설정한다.
            con = DriverManager.getConnection("jdbc:mysql://localhost/employee", "ohgiraffers", "ohgiraffers");

            // 누구와 연결되었는지 확인  - // con = com.mysql.cj.jdbc.ConnectionImpl@7817fd62 (mysql 과 연결되었다.)
            System.out.println("con = " + con);

            // 예외 처리 잘 찾아보기
        } catch (ClassNotFoundException e) { // forName()메서드의 예외처리 // ClassNotFoundException : Class 가 발견되지 않았을 떄 발생한다.
            throw new RuntimeException(e);
        } catch (SQLException e) { // getConnection()의 예외처리 // SQLException : 데이터베이스 컨텍스트에서 실패할 때 발생한다.
            throw new RuntimeException(e);
        } finally {
            if (con != null) {  // 통로를 열지 않고 닫으려고 하면 NullPointException 이 발생한다. 그래서 if 문으로 방지한다.
                try { // NullPointException :
                    con.close(); // 객체를 닫아서 메모리 누수를 막는다.(객체를 가비지컬렉터에게 줘서 없앤다)
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
