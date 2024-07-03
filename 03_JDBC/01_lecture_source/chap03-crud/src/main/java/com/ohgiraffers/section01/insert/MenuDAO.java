package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.Template.close;

/**
 * DAO(Data Access Object)
 *
 * - DB를 사용하여 데이터의 조회 및 조작하는 기능을 담당
 * - 데이터에 접근하기 위해 생성하는 객체
 * - 데이터베이스에 접근하기 위한 로직과 비즈니스 로직을 분리하기 위해 사용되는 개념
 */

public class MenuDAO {
    // 마이바티스 스타일(직관적인 메서드)
    public int insertMenu(Connection con, MenuDTO menu) {

        // PreparedStatement 초기화
        PreparedStatement pstmt = null;
        // 반환할 결과값 선언
        int result = 0;

        // 값 4개를 등록하는 sql 문 - VALUES 앞에 띄어쓰기 필수! (띄어쓰기를 하지 않으면 VALUES 와 문장이 합쳐져서 오류가 생긴다.)
        // INSERT 구문은 특별하게 "INSERT INTO [테이블명]([컬럼1], [컬럼2], [컬럼2])" + "VALUES(?,?,?)" 이런 형태로 사용한다.
        String query = "INSERT INTO TBL_MENU(MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS) "
                + "VALUES(?,?,?,?)";

        try {
            // preparedStatement() 객체에 query 문을 전달
            pstmt = con.prepareStatement(query);

            // SetXxx(index, value) : 각 컬럼 부분(index)에 값을 전달
            pstmt.setString(1, menu.getMenuName());
            pstmt.setDouble(2, menu.getMenuPrice());
            pstmt.setInt(3, menu.getCategoryCode());
            pstmt.setString(4, menu.getOrderalbeStatus());

            // executeUpdate()는 INSERT, UPDATE, DELETE 와 같은 DML(Data Manipulation Language)에서
            // 실행 결과로 영향을 받은 레코드 수를 반환한다.
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
