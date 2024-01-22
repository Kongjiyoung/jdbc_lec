package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getInstance(){ //Connection 소켓객체
        String username = "root";
        String password = "1234";
        String url="jdbc:mariadb://localhost:3306/cosdb"; //jdbc:mariadb://아이피명:포트명/데이터베이스명

        //프로토콜이 적용된 소켓
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("db connect success");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // return null;은 예외 발생 시 반환할 값이 없는 경우에 대한 처리 방법
    }
}
