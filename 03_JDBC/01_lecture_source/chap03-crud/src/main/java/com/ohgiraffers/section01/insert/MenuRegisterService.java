package com.ohgiraffers.section01.insert;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;

/**
 *  Service 클래스 : 핵심 업무(비즈니스 로직)을 수행한다
 *  Transaction : 하나의 비즈니스 로직은 하나의 트랜잭션으로 동작한다.
 *  관된 두 개 이상의 쿼리를 실행할 때, 모든 작업이 끝났을 때 COMMIT 을 수행하고 중간에 오류가 발생하면 ROLLBACK 하는 것이 기본이다.
 *
 *  트랜젝션 : "데이터베이스"에서 한 번에 실행되어야 할 여러 작업들이 묶인 논리적인 작업 단위로 데이터의 일관성과 무결성을 보장하는 데 매우 중요한 역할을 한다.
 *
 *  ⭐"트랜잭션"은 "데이터베이스"에서 어떤 로직을 작동하는 지 정의하고 db와 직접적으로 연관된 동작은 DAO 에서 메서드로 관리한다.⭐
 */

public class MenuRegisterService {

    // 하나의 트랜젝션은 하나의 Connection 을 가진다.
    // menu 를 추가하는 메서드 결과에 따라서 T/F 반환
    public boolean registerMenu(MenuDTO menu) {

        // 생성과 닫음 사이에 DML 문을 작성한다. -> SQL 문을 나누는 이유는 재사용성 때문이다.

        // 테이블 당 하나의 클래스는 만들어야한다.
        Connection con = getConnection();

        // ⭐ 트랜젝션에 대한 제어가 DAO 의 핵심이다! ⭐
        // MenuDAO 의 메서드를 사용하기 위해서 객체 생성
        MenuDAO menuDAO = new MenuDAO();
        // DAO 의 메서드가 실행한 결과를 정수형 변수에 담는다. (성공하면 1, 실패하면 0) - 성공한 행(row)만큼 index 반환이다 1줄 추가라서 1이 반환된다.
        int result = menuDAO.insertMenu(con, menu);

        /**
         *  commit : 트랜잭션의 작업을 최종적으로 데이터베이스에 반영하는 과정을 의미한다.
         *           트랜잭션에 포함된 논리 작업 단위를 성공적으로 수행되었고, 데이터가 무결성을 준수한다면 Commit 을 통해 데이터베이스에 반영한다.
         *           그 이후에 반영된 데이터는 다른 트랜잭션에서 참조할 수 있다.
         *
         *           = 아직 저장되지 않은 데이터를 데이터베이스(DB)에 저장하고 트랜잭션을 종료시키는 것
         *
         *  rollback : 중간에 에러가 발생했을 경우에 트랜잭션의 작업을 취소하고 이전 최초의 상태로 되돌리는 과정.
         *             여러 개의 작업 단위가 트랜잭션으로 관리될 때, 코드가 동작하는 과정에서 문제가 발행하여 데이터베이스에 반영되지 않고,
         *             다음 작업으로 넘어가게 된다면 다음 작업에서 확인할 수 있는 데이터와 일관되지 않다는 것을 알 수 있다.
         *
         *             = 작업 중 문제가 발생했을 때, 트랜젝션의 처리 과정에서 발생한 변경 사항을 취소하고, 트랜젝션 과정을 종료시킨다.
         *               트랜젝션으로 인한 하나의 묶음 처리가 시작되기 이전의 상태로 되돌린다.
         */


        // commit, rollback : Template 에 메서드 추가
        // 정상작동을 했다면 commit, 아니라면 rollback 을 한다.
        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        // 외부자원 종료
        close(con);

        // resultSet에서 반환하는 게 1이상 이어야 하는데 0이 나오면 문제가 있으니까 false 를 반환
        return result > 0;
    }

}
