package com.ohgiraffers.section02.preparedstatement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.ohgiraffers.common.Template.close;
import static com.ohgiraffers.common.Template.getConnection;

public class Application2 {
    public static void main(String[] args) {

        // employee 테이블에서 '중' 이 이름에 포함된 사원을 조회하세요 (중 이라고 하는 글자를 스캐너로 입력)
        // 단, List<EmployeeDTO> 에 담아서 출력하세요.

        Scanner sc = new Scanner(System.in);
        System.out.print("검색할 사원의 이름을 입력하세요. : ");
        String empName = sc.nextLine();


        // -----------------------------------------------------------


        // 연결할 수 있는 객체를 만든다.
        Connection con = getConnection();
        // 데이터를 받는 객체
        ResultSet rset = null;
        // 정보 요청 객체
        PreparedStatement pstmt = null;
        // 값을 저장할 수 있는 DTO 만들기
        EmployeeDTO empt = null;
        List<EmployeeDTO> empList = new ArrayList<>();


        try {

            // query 문 작성 - INSTR(기준 문자열, 부분 문자열) : INSTR: 기준 문자열에서 부분 문자열의 시작 위치 반환
            String query = "SELECT EMP_NAME FROM EMPLOYEE WHERE INSTR(EMP_NAME, ?)";

            // 전달하는 객체에게 쿼리문 전달
            pstmt = con.prepareStatement(query);

            // 전달하기 전에 <?>안에 값 넣기
            pstmt.setString(1, empName);

            // 결과를 객체로 받기
            // SELECT 문과 같은 쿼리문을 실행할 때 사용한다.
            // 쿼리를 실행하고, 결과를 ResultSet 객체로 반환한다. 반환된 ResultSet 객체를 통해 결과를 가져올 수 있다.
            rset = pstmt.executeQuery();
            while (rset.next()) {
                empt = new EmployeeDTO();
                empt.setEmpName(rset.getString("EMP_NAME"));
                empList.add(empt);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(con);
            close(pstmt);
            close(rset);
        }

        empList.forEach(System.out::println);


    }
}
