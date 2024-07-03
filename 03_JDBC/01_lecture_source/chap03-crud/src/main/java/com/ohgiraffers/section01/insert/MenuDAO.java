package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.Template.close;

public class MenuDAO {
    // 마이바티스 스타일
    public int insertMenu(Connection con, MenuDTO menu) {
        PreparedStatement pstmt = null;
        int result = 0;

        // 값 4개를 등록하는 sql 문 - values 앞에 띄어쓰기 필수! (띄어쓰기를 하지 않으면 VALUES 와 문장이 합쳐져서 오류가 생긴다.
        String query = "INSERT INTO TBL_MENU(MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS) "
                + "VALUES(?,?,?,?)";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menu.getMenuName());
            pstmt.setDouble(2, menu.getMenuPrice());
            pstmt.setInt(3, menu.getCategoryCode());
            pstmt.setString(4, menu.getOrderalbeStatus());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            // connection 은 닫으면 안된다. -> 계속 사용해야하기 때문에 닫을 시 사용하지 못한다.
            close(pstmt);
        }
        return result;
    }

    // jPA 스타일
    // public int save() {}
}
