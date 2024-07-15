package com.ohgiraffers.setion01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Application {
    
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost:3306/menudb";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";
    
    // db에 접근하기 위해서는 db 에 접근하기 위한 환경설정을 해야한다. -> Environment 
    
    public static void main(String[] args) {

        /**
         * DB 접속에 관한 환경 설정
         * JDBCTransactionFactory       :   수동 커밋 ()
         * ManagedTransactionFactory    :   자동 커밋 (JDBC 설정에 맡기겠다.)
         * 
         * PooledDataSource     :   ConnectionPool 사용
         * UnPooledDataSource   :   ConnectionPool 미사용
         *
         * DB와 연결하기 위해서는 Connection 이라는 객체가 필요하다.
         *  -> Application 레벨에서 Connection 을 많이 만들고 DB가 필요한 쓰레드에서 빌려가는 방법을 사용한다.
         * 
         */


        Environment environment = new Environment("dev", //id : 구분하기 위한 이름
                new JdbcTransactionFactory(), // 트랜젝션 매니저의 종류 결정 (JDBC or MANAGED)
                new PooledDataSource(DRIVER,URL,USER,PASSWORD)); // ConnectionPool 사용 유무 (Pooled or UnPooled)

        //ibatis 임포트 해!!!
        Configuration configuration = new Configuration(environment); // Environment 객체 선언 필수!! // 환경설정을 하면 Mapper 에 등록해야 한다.

        // Mapper 등록
        configuration.addMapper(Mapper.class);

        /**
         * SqlSessionFactory : SqlSession 객체를 생성하기 위한 팩토리 역할의 인터페이스
         * SqlSessionFactoryBuilder : SqlSessionFactory 인터페이스 하위 구현 객체를 생성하기 위한 빌드 역할
         */

        //
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = sqlSessionFactory.openSession(false); // true/false 설정 가능 => connection autocommit 설정

        System.out.println(sqlSession);

        Mapper mapper = sqlSession.getMapper(Mapper.class); // 꺼낼때는 getMapper
        java.util.Date date = mapper.selectSysdate();

        System.out.println(date);
    }
}
