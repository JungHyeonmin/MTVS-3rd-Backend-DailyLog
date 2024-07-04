package com.ohgiraffers.section03.update;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MenuDAO {

    public int updateMenu(Connection con, MenuDTO menuDTO) {
        int result = 0;
        // 요청문을 전달할 객체를 생성
        PreparedStatement pstmt = null;

        // 요청문 작성
        String query = "UPDATE TBL_MENU SET MENU_NAME=?, MENU_PRICE=?, CATEGORY_CODE=?, ORDERABLE_STATUS=? WHERE MENU_CODE = ?";


        try {
            // 쿼리문을 요청문에 적용
            pstmt = con.prepareStatement(query);

            // 쿼리문의 <?>에 값을 적용
            pstmt.setString(1, menuDTO.getMenuName());
            pstmt.setDouble(2, menuDTO.getMenuPrice());
            pstmt.setInt(3, menuDTO.getCategoryCode());
            pstmt.setString(4, menuDTO.getOrderalbeStatus());
            pstmt.setInt(5, menuDTO.getMenuCode());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}