package com.ohgiraffers.section03.update;

// 트랜젝션 : 데이터베이스에서 한 번에 실행되어야 할 여러 작업들이 묶인 논리적인 작업 단위로
// 데이터의 일관성과 무결성을 보장하는 데 매우 중요한 역할을 한다.

// 주 역할 : 트랜젝션 담당
// 하나의 트랜젝션은 하나의 Connection 을 가진다.

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;

public class MenuReplaceService {
    public boolean replaceMenu(MenuDTO menu) {

        Connection con = getConnection();

        MenuDAO menuDAO = new MenuDAO();
        int result = menuDAO.replaceMenu(con, menu, menu); // 수정

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }


        close(con);

        return result >0;
    }
}
