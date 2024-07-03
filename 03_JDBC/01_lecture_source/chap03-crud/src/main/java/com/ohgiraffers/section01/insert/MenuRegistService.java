package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;

// 기능을 만든다 == Service 하나를 만든다.ㄴ

public class MenuRegistService {

    // Service - 여기에서 Connection 을 만들고 닫는다.
    // 주 역할 : 트랜젝션 담당
    // 하나의 트랜젝션은 하나의 Connection 을 가진다.
    public boolean registMenu(MenuDTO menu) {

        // 생성과 닫음 사이에 DML 문을 작성한다. SQL 문을 나누는 이유는 재사용성 때문이다.
        // 테이블 당 하나의 클래스는 만들어야한다.
        Connection con = getConnection();

        // ⭐ 트랜젝션에 대한 제어가 DAO 의 핵심이다! ⭐
        MenuDAO menuDAO = new MenuDAO();
        int result = menuDAO.insertMenu(con, menu);

        // commit, rollback : Template 에 메서드 추가
        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        //
        return result > 0;
    }

}
