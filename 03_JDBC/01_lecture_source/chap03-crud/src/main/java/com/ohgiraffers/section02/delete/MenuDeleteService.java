package com.ohgiraffers.section02.delete;

// Service - 여기에서 Connection 을 만들고 닫는다.
// 기능을 만든다 == Service 하나를 만든다.
// 삭제 하는 서비스

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;
import static com.ohgiraffers.common.Template.close;

public class MenuDeleteService {
    public boolean deleteMenu(MenuDTO menu) {

        Connection con = getConnection();


        MenuDAO menuDAO = new MenuDAO();
        int result = menuDAO.deleteMenu(con, menu);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }


        close(con);

        return result > 0;
    }
}
