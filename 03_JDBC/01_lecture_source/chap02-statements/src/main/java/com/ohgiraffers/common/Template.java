package com.ohgiraffers.common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

// Connection 객체를 생성하는 코드 또한 중복 작성하게 되므로,
// Template 클래스의 static 메서드로 Connection 객체를 생성하거나 반납하는 코드를 작성하여 공통으로  사용하도록 하는 것이 일반적이다.
// ⭐주의 사항⭐ 1. 자원 반납시에는 null 체크와 이미 반납된 자원인지 아닌지 확인한다. 2. 외부 자원 때문에 열어둔 통로는 닫아줘야한다.

public class Template {

    public static Connection getConnection() {

        // Connection 클래스 : db와 연결할 수 있게 해주는 클래스
        Connection con = null;

        // Properties : Properties 프로그램 설정정보를 개발코드에 불러오거나 새로운 정보를 추가, 수정, 저장 할 수 있게 해준다.
        Properties props = new Properties();


        try { // Properties.load : 스트림으로 열린 Properties 파일 객체(FileReader)를 로드 함
            props.load( // FileReader() : character 파일을 읽을 수 있는 기능을 제고
                    new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));

            // getProperty("key") : key 값을 제공하면 해당하는 Value 를 문자열로 반환함
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");

            // 클래스 동적 로딩(런타임 중에 동작), 사용할 드라이버 등록
            // Class.forName() : Class 클래스는 클래스의 메타 정보를 가지고 있다.
            // forName() : 메서드에 풀 클래스명을 작성하면 해당 클래스를 메모리에 올려 사용할 준비를 하도록 하는 것으로, 동적 로딩을 이용하여 DB driver 를 로딩한다.
            // -> 주의사항 1. 반드시 예외처리를 해야한다. 2. 직접 instance 가 불가능하고 DriverManager 클래스의 getConnection()메서드를 이용하여 인스턴스를 생성한다.
            Class.forName(driver);

            // url 과 properties 파일만으로 객체 생성 -> 왜 유저랑 비번은 사용하지 않는거야?
            con = DriverManager.getConnection(url, props);

        } catch (IOException e) { // 입출력 문제(FileReader)
            throw new RuntimeException(e);
        } catch (SQLException e) { // 데이터베이스 연결 문제
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {  // forName 문제
            throw new RuntimeException(e);
        }
        
        // 연결할 수 있는 Connection 객체를 반환
        return con;
    }

    // Connection 객체 메모리 해제 메서드 - 연결 후 닫아주기
    public static void close(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Statement 객체 메모리 해제 메서드
    public static void close(Statement stmt) {
        try {
            if (stmt != null && !stmt.isClosed()) {
                stmt.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // ResultSet 객체 메모리 해제 메서드
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