package com.ohgiraffers.section03.update;


import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.ohgiraffers.common.Template.close;
import static com.ohgiraffers.common.Template.getConnection;

public class MenuDAO {
    public int replaceMenu(Connection con, MenuDTO menu, MenuDTO newMenu) {
        // 요청문을 보내고 받을 객체를 생성
        PreparedStatement pstmt = null;
        int result = 0;

        // 요청문 (query)문 생성
        String query = "REPLACE INTO TBL_MENU(MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS) "
                + "VALUES(?,?,?,?)" + "WHERE = ?";
        try {
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, newMenu.getMenuName());
            pstmt.setDouble(2, newMenu.getMenuPrice());
            pstmt.setInt(3, newMenu.getCategoryCode());
            pstmt.setString(4, newMenu.getOrderalbeStatus());

            pstmt.setString(5, menu.getMenuName());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            close(pstmt);
        }

        return result;
    }
}
