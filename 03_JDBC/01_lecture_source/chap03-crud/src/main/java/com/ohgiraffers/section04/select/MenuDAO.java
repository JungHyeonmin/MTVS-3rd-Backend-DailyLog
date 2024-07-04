package com.ohgiraffers.section04.select;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.Template.close;

/**
 * DAO(Data Access Object)
 * <p>
 * - DB를 사용하여 데이터의 조회 및 조작하는 기능을 담당
 * - 데이터에 접근하기 위해 생성하는 객체
 * - 데이터베이스에 접근하기 위한 로직과 비즈니스 로직을 분리하기 위해 사용되는 개념
 */

public class MenuDAO {

    // menuCode 로 찾고 menu 로 가져와서
    public ResultSet readMenu(Connection con, MenuDTO menu) {
        // 요청문 전달 객체
        PreparedStatement pstmt = null;
        // 조회 결과를 받을 객체
        ResultSet rset = null;

        // 1. query 에 요청문 작성
        String query = "SELECT * FROM TBL_MENU WHERE MENU_NAME = ?";

        try {
            // 2. 전달 객체에 요청문 전달
            pstmt = con.prepareStatement(query);

            // 3. 요청문의 <?>에 값 넣기
            pstmt.setString(1, menu.getMenuName());

            // 4. 조회 결과를 받아야 하기 때문에 값을 받을 객체 저장
            rset = pstmt.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rset;
    }
}
