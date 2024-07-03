package com.ohgiraffers.section02.delete;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.Template.*;

public class MenuDAO {


    public int deleteMenu(Connection con, MenuDTO menu) {

        PreparedStatement pstmt = null;
        int result =0;

        // DELETE 쿼리 : TBL_MENU 에서 <?>의 값과 같은 MENU_NAME 을 지운다.
        String query = "DELETE FROM TBL_MENU WHERE MENU_NAME = ?";

        try {
            pstmt = con.prepareStatement(query);

            pstmt.setString(1, menu.getMenuName());

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return result;
    }
}
