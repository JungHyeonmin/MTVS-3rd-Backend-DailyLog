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


//        Scanner sc = new Scanner(System.in);
//        System.out.print("조회할 사번을 입력하세요 : ");
//        String empId = sc.nextLine();

        // ----------------------------------------------------------------
        // connection 생성
        Connection con = getConnection();
        Statement stmt = null;
        ResultSet rset = null;
        List<EmployeeDTO> empList = null;

        try {
            stmt = con.createStatement();

            // select 시 executeQuery => return type ResultSet(조회된 결과 집합)
            // insert, update, delete 시 executeUpdate => return type int(변경된 행의 수)
            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE";
            System.out.println(query);

            rset = stmt.executeQuery(query);
            empList = new ArrayList<>();

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