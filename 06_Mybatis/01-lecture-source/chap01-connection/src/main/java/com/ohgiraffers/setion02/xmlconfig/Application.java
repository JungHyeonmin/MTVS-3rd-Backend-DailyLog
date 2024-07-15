package com.ohgiraffers.setion02.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Application {

    public static void main(String[] args) {

        String resource = "mybatis-config.xml"; // (경로명 작성)

        InputStream inputStream;

        {
            try {

                // SqlSessionFactory : mapper 를 찍어내는 공장이다. Application 한개당 한개만 만드는 것을 권장한다.
                inputStream = Resources.getResourceAsStream(resource);
                SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                SqlSession sqlSession = sqlSessionFactory.openSession(false);

                // selectOne() : 한개의 행만 조회
                // mapper 라는 이름의 mapper 파일의 selectSysdate 라는 명령문을 실행해라
                java.util.Date date = sqlSession.selectOne("mapper.selectSysdate");

            } catch (IOException e) {

                throw new RuntimeException(e);

            }
        }

    }


}
