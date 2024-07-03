package com.ohgiraffers.sqlinjection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.ohgiraffers.common.Template.close;
import static com.ohgiraffers.common.Template.getConnection;

public class Application1 {

    // 찾고자 하는 정보
    private static String empId = "200";
    private static String empName = "선동일";


    public static void main(String[] args) {


        // db와 연결할 수 있는 객체 생성
        Connection con = getConnection();

        // 요청문을 전달하고 받는 객체와 결과를 저장하는 객체는 null 로 초기화
        Statement stmt = null;
        ResultSet rset = null;

        // query 문에 요청문 전달
        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = '" + empId + "' AND EMP_NAME +'" + empName + "'";
        // System.out.println("query = " + query);

        try {
            // createStatement() : getConnection 처럼 데이터베이스로 SQL 문을 보내기 위한 SQLServerStatement 개체를 만듭니다.
            stmt = con.createStatement();
            // executeQuery(query) : 쿼리를 실행하고, 결과를 ResultSet 객체로 반환한다. 반환된 ResultSet 객체를 통해 결과를 가져올 수 있다.
            rset = stmt.executeQuery(query);

            // next() : 커서의 다음 행이 존재할 경우 true 를 반환
            // 커서(Cursor) : 일련의 데이터에 순차적으로 액세스할 때 검색 및 "현재 위치"를 포함하는 데이터 요소이다.
            if (rset.next()) {
                System.out.println(rset.getString("EMP_NAME") + "님 환영합니다.");
            } else {
                System.out.println("회원 정보가 없습니다.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 자원(메모리에 할당된 인스턴스)이 아니라 운영체제의 자원(시스템 자원) 해제
            close(con);
            close(stmt);
            close(rset);
        }
    }
}
