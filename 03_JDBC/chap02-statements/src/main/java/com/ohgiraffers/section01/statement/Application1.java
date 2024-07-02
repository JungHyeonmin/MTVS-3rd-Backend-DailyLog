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

        // connection 생성 - Connection 객체란? 자바에서 DB와 연결하기 위해 사용하는 객체
        Connection con = getConnection(); // getConnection() : 실제 자바 프로그램과 데이터베이스를 네트워크 상에서 연결해 주는 메서드
        Statement stmt = null; // SQL 문을 저장하고 실행한 뒤 결과를 받아 반환해주는 메소드
        ResultSet rset = null; // 결과값 저장, 저장된 값을 한 행 당뉘로 불러올 수 있다. 한 행에서 값으 가져올 때는 타입을 지정해 불러올 수 있다.

        // EmployeeDTO selectedEmp = null;
        List<EmployeeDTO> empList = null;

        try {
            stmt = con.createStatement(); // createStatement() : 원하는 데이터를 sql 에서 parsing 하는 것

            // select 시 executeQuery => return type ResultSet(조회된 결과 집합)
            // insert, update, delete 시 executeUpdate => return type int(변경된 행의 수)

            Scanner sc = new Scanner(System.in);
            System.out.print("조회할 사번을 입력하세요 : ");
            String empId = sc.nextLine();

            // String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = '" + empId + "'";
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE"; // query : db에 정보를 요청하는 일
            System.out.println(query);

            rset = stmt.executeQuery(query);

            //selectedEmp = new EmployeeDTO();
            empList = new ArrayList<>();
            if (rset.next()) {
                // selectedEmp = new EmployeeDTO();
                // selectedEmp.setEmpId(rset.getString("EMP_ID"));
                // selectedEmp.setEmpName(rset.getString("EMP_NAME"));
                // System.out.println(rset.getString("EMP_ID") + " " + rset.getString("EMP_NAME"));

                EmployeeDTO row = new EmployeeDTO();
                row.setEmpId(rset.getString("EMP_ID"));
                row.setEmpId(rset.getString("EMP_NAME"));

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

        // -----------------------------
        // 리턴 해줄 위치
        // System.out.println(selectedEmp);
        empList.forEach(System.out::println);
    }
}