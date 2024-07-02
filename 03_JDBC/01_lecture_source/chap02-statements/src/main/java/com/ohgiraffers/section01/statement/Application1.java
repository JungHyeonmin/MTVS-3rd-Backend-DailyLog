package com.ohgiraffers.section01.statement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.common.Template.close;
import static com.ohgiraffers.common.Template.getConnection;

public class Application1 {

    public static void main(String[] args) {


        // Scanner sc = new Scanner(System.in);
        // System.out.print("조회할 사번을 입력하세요 : ");
        // String empId = sc.nextLine();

        // ----------------------------------------------------------------
        // connection 생성 :db 와 연결할 수 있게 해준다.
        Connection con = getConnection(); // template 로 db와 연결
        Statement stmt = null; // Statement 객체 null 로 초기화
        ResultSet rset = null; // ResultSet 객체 null 로 초기화

        List<EmployeeDTO> empList = null; // db 에서 받을 데이터를 EmployeeDTO 로 객체마다 저장하는데 각 객체들을 List 로 저장한다.

        try {
            // Connection class 의 createStatement() 메소드를 호출하여 Statement instance 를 생성한다.
            // Statement : Connection 객체로부터 sql 문을 DB에 전달하여 실행하고 결과를 리턴받는 객체
            stmt = con.createStatement();

            // select 시 executeQuery => return type ResultSet(조회된 결과 집합)
            // insert, update, delete 시 executeUpdate => return type int(변경된 행의 수)
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE"; // query 에 질문할 문장을 SQL 문으로 작성한다.
            System.out.println(query);

            // 생성한 instance 의  executeQuery() 메소드를 호출하여 SQL 문 수행한다. (SQL 문을 String 형태로 인자로 전달한다.)
            // ResultSet : SELECT 문 수행 성공 시 반환한 결과값을 받아오는 객체이다.
            // query : 데이터베이스에 정보를 요청하는 일(질의문, 무슨무슨 정보 보여줘, 수정할게~ 등..)
            rset = stmt.executeQuery(query);
            empList = new ArrayList<>();

            // 반복문을 이용해서 리스트에 각 객체를 저장
            // next() : 다음값이 있는지 확인 없으면 false, 있으면 true
            while(rset.next()) {
                EmployeeDTO row = new EmployeeDTO();
                row.setEmpId(rset.getString("EMP_ID"));
                row.setEmpName(rset.getString("EMP_NAME"));

                empList.add(row);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            // connection, stmt, rset 닫기
            close(con);
            close(stmt);
            close(rset);
        }
        // --------------------------------------
        // 리턴 해줄 위치
        empList.forEach(System.out::println);
    }
}