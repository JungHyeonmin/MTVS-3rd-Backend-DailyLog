package com.ohgiraffers.section02.template;

import java.sql.Connection;

// 스테틱 메서드의 경우 [import static 경로.클래스.메서드] 이런식으로 import 선언 후 메서드앞에 클래스를 생략해서 표현할 수 있다.
import static com.ohgiraffers.section02.template.Template.*;
import static com.ohgiraffers.section02.template.Template.close;

public class Application {
    public static void main(String[] args) {

        // Connection 클래스 : db와 연결할 수 있게 해주는 클래스
        Connection con = getConnection(); // 클래스명을 import 형식으로 변환
        System.out.println("con = " + con);

        // 메모리를 해제하는 메서드
        close(con);
    }
}
