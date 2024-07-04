package com.ohgiraffers.section03.update;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;

public class MenuReplaceService {

    public boolean replaceMenu(MenuDTO menuDTO) {
        // 연결할 수 있는 객체 생성
        Connection con = getConnection();

        // 데이터베이스를 직접 다루는 DAO 객체를 생성
        MenuDAO menuDAO = new MenuDAO();

        // DAO 에서 받은 결과를 가지고 커밋과 롤백을 결정한다.
        int result = menuDAO.updateMenu(con, menuDTO);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        // Select 문은 정보를 반환, 나머지는 행의 수를 반환한다.
        return result > 0;
    }

}