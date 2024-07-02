package com.ohgiraffers.section02.template;

import java.sql.Connection;

import static com.ohgiraffers.section02.template.Template.*;
import static com.ohgiraffers.section02.template.Template.close;

public class Application {
    public static void main(String[] args) {

        Connection con = getConnection(); // 클래스명을 import 형식으로 변환
        System.out.println("con = " + con);

        close(con);
    }
}
