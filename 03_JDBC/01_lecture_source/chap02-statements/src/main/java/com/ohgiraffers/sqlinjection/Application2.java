package com.ohgiraffers.section03.sqlinjection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.Template.close;
import static com.ohgiraffers.common.Template.getConnection;

public class Application2 {

    private static String empId = "200";
    private static String empName = "' OR 1=1 AND EMP_ID = '200";

    public static void main(String[] args) {

        // db와 연결해주는 객체 생성, 요청문을 보내고 받는 객체와 데이터를 저장하는 객체는 null 로 초기화
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        // EMP_ID 와 EMP_NAME 은 <?> 안에 아무 값이나 넣을 수 있도록 하고 넣은 값을 EMPLOYEE db 에서 조회하는 sql 문을 쿼리 문자열에 저장
        String query = "SELECT * FROM EMPLOYEE WHERE EMP_ID = ? AND EMP_NAME = ?";

        try {
            // query(요청문)문을 가지고 preparedStatement 객체 저장
            pstmt = con.prepareStatement(query);
            
            // ? 의 위치에 따라서 값을 전달
            pstmt.setString(1, empId);
            pstmt.setString(2, empName);

            // executeQuery(query) : 쿼리를 실행하고, 결과를 ResultSet 객체로 반환한다. 반환된 ResultSet 객체를 통해 결과를 가져올 수 있다.
            rset = pstmt.executeQuery();

            // 가져온 행에서 다음 커서가 있으면 
            if(rset.next()) { // rset에 저장된 값 중에서 EMP_NAME 컬럼을 문자열로 출력
                System.out.println(rset.getString("EMP_NAME") + "님 환영합니다.");
            } else {
                System.out.println("회원 정보가 없습니다.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // 외부자원 닫기
            close(rset);
            close(pstmt);
            close(con);
        }
    }
}