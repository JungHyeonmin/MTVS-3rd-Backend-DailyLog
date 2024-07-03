package com.ohgiraffers.section02.preparedstatement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.ohgiraffers.common.Template.getConnection;
import static com.ohgiraffers.common.Template.close;

public class Application1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 사번을 입력하세요. : ");

        String empId = sc.nextLine();

        // ---------------------------------------------------------------
        Connection con = getConnection();

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        EmployeeDTO selectedEmp = null;

        // 괄호 안에 ?를 넣을 수 있는 미완성/완성 문장을 넣을 수 있다.
        try {
            // pstmt = con.prepareStatement("SELECT EMP_ID, EMP_NAME FROM EMPLOYEE"); // 완성문

            String query = "SELECT EMP_ID, EMP_NAME FROM EMPLOYEE WHERE EMP_ID = ? ";
            pstmt = con.prepareStatement(query); // 비완성문

            pstmt.setString(1, empId);

            rset = pstmt.executeQuery();

            // Statement 와 PreparedStatement 의 차이점
            // 빈상태롤 넣고 한다. vs 넣고 빈상태로 실행한다.

            /*
            while (rset.next()) {
                // System.out.println(rset.getString("EMP_ID") + " " + rset.getString("EMP_NAME")); // 출력 확인
            }
            */

            if (rset.next()) {
                selectedEmp = new EmployeeDTO();
                selectedEmp.setEmpId(rset.getString("EMP_ID"));
                selectedEmp.setEmpId(rset.getString("EMP_NAME"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(pstmt); // pstmt 는 만들지 않았지만 Statement 의 하위 인터페이스라서 Statement 의 상속을 받는다.
            close(rset);
        }

        System.out.println(selectedEmp);
    }
}
