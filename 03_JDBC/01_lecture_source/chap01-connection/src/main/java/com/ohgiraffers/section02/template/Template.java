package com.ohgiraffers.section02.template;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Template {
    public static Connection getConnection() {

        Connection con = null;

        Properties props = new Properties();

        try {
            props.load(
                    new FileReader("src/main/java/com/ohgiraffers/config/connection-info.properties"));

            System.out.println("props = " + props);

            String driver = props.getProperty("driver");
            String url = props.getProperty("url");

            Class.forName(driver);

            // url 과 properties 파일만으로 객체 생성
            con = DriverManager.getConnection(url,props);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return con;
    }

    public static void close(Connection con) {

        try {
            if (con != null & !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
