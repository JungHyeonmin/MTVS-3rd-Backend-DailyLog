package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;


// Service - 여기에서 Connection 을 만들고 닫는다.
// 기능을 만든다 == Service 하나를 만든다.
// 등록을 하는 서비스
public class MenuRegisterService {


    // 트랜젝션 : 데이터베이스에서 한 번에 실행되어야 할 여러 작업들이 묶인 논리적인 작업 단위로
    // 데이터의 일관성과 무결성을 보장하는 데 매우 중요한 역할을 한다.

    // 주 역할 : 트랜젝션 담당
    // 하나의 트랜젝션은 하나의 Connection 을 가진다.

    public boolean registerMenu(MenuDTO menu) {

        // 생성과 닫음 사이에 DML 문을 작성한다. SQL 문을 나누는 이유는 재사용성 때문이다.
        // 테이블 당 하나의 클래스는 만들어야한다.
        Connection con = getConnection();

        // ⭐ 트랜젝션에 대한 제어가 DAO 의 핵심이다! ⭐
        MenuDAO menuDAO = new MenuDAO();
        int result = menuDAO.insertMenu(con, menu);

        // commit : 트랜잭션의 작업을 최종적으로 데이터베이스에 반영하는 과정을 의미한다.
        // 트랜잭션에 포함된 논리 작업 단위를 성공적으로 수행되었고, 데이터가 무결성을 준수한다면 Commit 을 통해 데이터베이스에 반영한다.
        // 그 이후에 반영된 데이터는 다른 트랜잭션에서 참조할 수 있다.

        // 여러 개의 작업 단위가 트랜잭션으로 관리될 때, 코드가 동작하는 과정에서 문제가 발행하여 데이터베이스에 반영되지 않고,
        // 다음 작업으로 넘어가게 된다면 다음 작업에서 확인할 수 있는 데이터와 일관되지 않다는 것을 알 수 있다.
        // rollback : 중간에 에러가 발생했을 경우에 트랜잭션의 작업을 취소하고 이전 최초의 상태로 되돌리는 과정


        // commit, rollback : Template 에 메서드 추가
        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        // resultSet에서 반환하는 게 1이상 이어야 하는데 0이 나오면 문제가 있으니까 false 를 반환
        return result > 0;
    }

}
